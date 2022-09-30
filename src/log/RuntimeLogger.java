package log;

import java.io.IOException;
import java.util.ArrayList;

import core.Sort.SortTester;

public class RuntimeLogger extends Logger 
{
    final private String FORMAT = "dat/raw_data/%sRuntime_%dSamples.csv";

    public RuntimeLogger(SortTester tester) throws IOException 
    {
        super(tester);
    }

    @Override
    public String getFilename() 
    {
        String sortName = this.tester.getSorter().getClass().getSimpleName();
        return String.format(FORMAT, sortName, this.tester.getK());
    }

    @Override
    public void print() throws IOException 
    {
        this.printHeaders();

        ArrayList<ArrayList<Double>> runtimes = this.tester.getRuntimes();

        int n = this.tester.getINIT_N();
        for(int i = 0; i < runtimes.size(); i++)
        {
            ArrayList<Double> samples = runtimes.get(i);

            this.printSamples(samples, n);
            n = n << 1;
        }

        this.writer.close();
    }

    private void printSamples(ArrayList<Double> samples, int n) throws IOException
    {
        for(int i = 0; i < samples.size(); i++)
        {
            double sample = samples.get(i);
            this.writer.append((i + 1) + "," + n + "," + sample + "\n");
        }
    }
    
    private void printHeaders() throws IOException
    {
        this.writer.append("sample_num,input_size,runtime\n");
    }
}
