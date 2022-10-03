package log.CSVLogger;

import java.io.IOException;

import core.data.Experiment;
import core.data.Runtime;

public class RuntimeLogger extends CSVLogger 
{
    public RuntimeLogger(Experiment experiment) throws IOException 
    {
        super(experiment);
    }

    @Override
    public String getFilename() 
    {
        FORMAT = DAT_DIR + "raw_data/%sRuntime_%dSamples.csv";

        String sortName = getSortName();
        int sampleSize = this.experiment.getSAMPLE_SIZE();

        return String.format(FORMAT, sortName, sampleSize);
    }

    @Override
    public void print() throws IOException 
    {
        this.printHeaders();

        while(results.hasNextRuntime())
        {
            Runtime currentRuntime = results.nextRuntime();
            writer.append(currentRuntime.toString() + "\n");
        }

        this.writer.close();
    }

    protected void printHeaders() throws IOException
    {
        this.writer.append("sample_num,input_size,runtime\n");
    }
}
