package core.data;

import java.util.ArrayList;

import core.sequence.SuffixArray;
import core.sort.Sorter;
import lombok.Getter;

@Getter
public class Experiment 
{
    final private Sorter sorter;
    final private String ALPHABET;
    final private int INIT_N = 128;
    final private int sampleSize;

    ArrayList<SuffixArray> suffixArrays;
    ArrayList<ArrayList<Double>> runtimes;

    ExperimentResults results;

    final private double RUNTIME_CAP = 50_000;
    private boolean isOverRuntimeCap = false;

    public Experiment(Sorter sorter, String alphabet, int k)
    {
        this.sorter = sorter;
        this.ALPHABET = alphabet;

        this.suffixArrays = new ArrayList<SuffixArray>();
        this.sampleSize = k;

        this.results = new ExperimentResults(sampleSize);
    }
    
    public void execute()
    {
        int n = INIT_N;
        this.runtimes = new ArrayList<ArrayList<Double>>();

        int i = 0;
        while(i < 7)
        {
            System.out.println("N = " + n);

            ArrayList<Double> samples = getSamples(n);
            this.runtimes.add(samples);
            
            n = n << 1;
            i++;
        }
    }

    private ArrayList<Double> getSamples(int n)
    {
        ArrayList<Double> samples = new ArrayList<Double>();

        for(int i = 0; i < this.sampleSize; i++)
        {
            SuffixArray suffArr = new SuffixArray(this.sorter, this.ALPHABET, n);
            this.suffixArrays.add(suffArr);

            double runtime = this.timeExecution(i, n);
            System.out.println("Observation #" + (i + 1) + ": " + Double.toString(runtime));

            samples.add(runtime);

            if(runtime > RUNTIME_CAP)
                this.isOverRuntimeCap = true;
        }

        return samples;
    }

    private double timeExecution(int i, int n)
    {
        int nIndex = (int) Math.round((Math.log(n) - Math.log(INIT_N)) / Math.log(2));

        long start = System.nanoTime();
        this.suffixArrays.get(nIndex * this.sampleSize + i).sort();
        long end = System.nanoTime();

        double runtime = (end - start) * 1e-6;
        return runtime;
    }
}
