package core.Sort;

import java.util.ArrayList;

import core.SuffixArray;
import lombok.Getter;

@Getter
public class SortTester 
{
    final private AbstractSort sorter;
    final private String ALPHABET;
    final private int INIT_N = 128;
    final private int k;

    ArrayList<SuffixArray> suffixArrays;
    ArrayList<ArrayList<Double>> runtimes;

    final private double RUNTIME_CAP = 50_000;
    private boolean isOverRuntimeCap = false;

    public SortTester(AbstractSort sorter, String alphabet, int k)
    {
        this.sorter = sorter;
        this.ALPHABET = alphabet;

        this.suffixArrays = new ArrayList<SuffixArray>();
        this.k = k;
    }
    
    public void execute()
    {
        int n = INIT_N;
        this.runtimes = new ArrayList<ArrayList<Double>>();

        int i = 0;
        while(i < 8)
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

        for(int i = 0; i < this.k; i++)
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
        this.suffixArrays.get(nIndex * this.k + i).executeSort();
        long end = System.nanoTime();

        double runtime = (end - start) * 1e-6;
        return runtime;
    }
}
