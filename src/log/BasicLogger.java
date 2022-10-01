package log;

import java.io.FileWriter;

import core.data.Experiment;
import core.data.ExperimentResults;
import lombok.Getter;
import lombok.Setter;

public abstract class BasicLogger implements Logger
{
    @Getter protected Experiment experiment;
    @Setter protected FileWriter writer;
    protected ExperimentResults results;
    
    protected final String DAT_DIR = "dat/"; 
    protected String FORMAT;

    protected String getSortName() 
    {
        return this.experiment.getSorter().getClass().getSimpleName();
    }
}
