package log;

import java.io.FileWriter;
import java.io.IOException;

import core.data.Experiment;
import core.data.ExperimentResults;
import lombok.Getter;
import lombok.Setter;

public abstract class CSVLogger implements Logger
{
    @Getter protected Experiment experiment;
    @Setter protected FileWriter writer;
    protected final ExperimentResults results;

    protected final String DAT_DIR = "dat/"; 
    protected String FORMAT;
    
    public abstract String getFilename();

    public CSVLogger(Experiment experiment) throws IOException
    {
        this.experiment = experiment;
        this.results = experiment.getResults();
        this.writer = new FileWriter(getFilename());
    }
}
