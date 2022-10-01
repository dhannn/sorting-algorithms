package log.CSVLogger;

import java.io.FileWriter;
import java.io.IOException;

import core.data.Experiment;
import log.BasicLogger;

public abstract class CSVLogger extends BasicLogger
{   
    protected abstract void printHeaders() throws IOException;

    public CSVLogger(Experiment experiment) throws IOException
    {
        this.experiment = experiment;
        this.results = experiment.getResults();
        this.writer = new FileWriter(getFilename());
    }
}
