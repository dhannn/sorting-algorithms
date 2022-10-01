package log;

import java.io.IOException;

import core.data.AverageRuntime;
import core.data.Experiment;

public class AverageLogger extends CSVLogger
{

    public AverageLogger(Experiment experiment) throws IOException 
    {
        super(experiment);
    }

    @Override
    public String getFilename() 
    {
        FORMAT = DAT_DIR + "%sAverageRuntime_%dSamples.csv";

        String sortName = this.experiment.getSorter().getClass().getSimpleName();
        int sampleSize = this.experiment.getSAMPLE_SIZE();

        return String.format(FORMAT, sortName, sampleSize);
    }

    @Override
    public void print() throws IOException 
    {
        this.printHeaders();

        while(results.hasNextAverage())
        {
            AverageRuntime currentRuntime = results.nextAverage();
            writer.append(currentRuntime.toString() + "\n");
        }

        this.writer.close();
    }

    private void printHeaders() throws IOException
    {
        this.writer.append("input_size,ave_runtime\n");
    }
}
