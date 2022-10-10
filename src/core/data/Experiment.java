package core.data;

import java.util.ArrayList;

import core.sequence.Sequence;
import core.sequence.SuffixArray;
import core.sort.Sorter;
import lombok.Getter;

@Getter
public class Experiment 
{
    final private Sorter sorter;
    final private String ALPHABET;
    final private int INIT_N = 128;
    final private int SAMPLE_SIZE;
    
    private final NanoConverter unit = NanoConverter.TO_MILLISECOND;

    ArrayList<SuffixArray> suffixArrays;
    ExperimentResults results;

    final private int MAX_INPUT_NUM = 8;

    public Experiment(Sorter sorter, String alphabet, int k)
    {
        this.sorter = sorter;
        this.ALPHABET = alphabet;

        this.suffixArrays = new ArrayList<SuffixArray>();
        this.SAMPLE_SIZE = k;
    }
    
    public void execute()
    {
        int n = INIT_N;
        results = new ExperimentResults(SAMPLE_SIZE, MAX_INPUT_NUM);
        
        int i = 0;
        while(i < MAX_INPUT_NUM)
        {
            System.out.println("N = " + n);
            getSamples(n);
            
            n = n << 1;
            i++;
        }

        results.calculateAverage();
    }

    private void getSamples(int inputSize)
    {
        for(int i = 0; i < this.SAMPLE_SIZE; i++)
        {
            Sequence sequence = new Sequence(ALPHABET, inputSize);
            sequence.generateRandom();

            SuffixArray suffArr = new SuffixArray(sorter, sequence);
            this.suffixArrays.add(suffArr);

            float runtime = this.timeExecution(suffArr);
            results.add(i, inputSize, runtime);

            System.out.println("Observation #" + (i + 1) + ": " + Double.toString(runtime));
        }
    }

    private float timeExecution(SuffixArray suffixArray)
    {
        long start = System.nanoTime();
        suffixArray.sort();
        long end = System.nanoTime();

        float runtime = (float)((end - start) * unit.getConversionFactor());
        return runtime;
    }
}
