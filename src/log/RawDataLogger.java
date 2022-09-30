package log;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import core.SuffixArray;
import core.Sort.SortTester;

public class RawDataLogger extends Logger
{
    final private String FORMAT = "dat/raw_data/%s_SuffixArrays_N%d_%d.txt";
    private int iter;
    private int iterK = 0;
    private int iterN = 0;

    public RawDataLogger(SortTester tester) throws IOException 
    {
        super(tester);
        this.writer.close();
    }

    @Override
    public String getFilename() 
    {
        SuffixArray currentSuffixArray = this.tester.getSuffixArrays().get(iter);
        String sortName = currentSuffixArray.getSorter().getClass().getSimpleName();
        return String.format(FORMAT, sortName, iterN, iterK + 1);
    }

    @Override
    public void print() throws IOException 
    {
        ArrayList<SuffixArray> suffixArrays = this.tester.getSuffixArrays();

        for(int i = 0; i < suffixArrays.size(); i++)
        {
            SuffixArray currentSuffixArray = suffixArrays.get(i);
            this.iter = i;
            this.iterN = currentSuffixArray.getInputSize();
            this.iterK = i % this.tester.getK();

            this.writer = new FileWriter(getFilename());
            this.printFile(currentSuffixArray);
            this.writer.close();
        }
    }

    private void printFile(SuffixArray curr) throws IOException
    {
        this.writer.append("Sequence:\n" + curr.getBaseSequence() + "\n");
        this.writer.append("\nSuffix array:\n");

        for(int i = 0; i < curr.getInputSize(); i++)
        {
            this.writer.append(curr.get(i) + "\n");
        }

        int nIndex = (int) Math.round((Math.log(iterN) - Math.log(this.tester.getINIT_N())) / Math.log(2));

        this.writer.append("\nRuntime:\n" + this.tester.getRuntimes().get(nIndex).get(iterK) + "ms\n");
    }
}
