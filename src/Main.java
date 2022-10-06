import java.io.IOException;

import core.data.Experiment;
import core.sort.ConcreteSort.MergeSort;
// import core.sort.ConcreteSort.QuickSort;
import core.sort.ConcreteSort.SelectionSort;
// import log.RawDataLogger;
// import log.CSVLogger.AverageLogger;
// import log.CSVLogger.RuntimeLogger;
import log.RawDataLogger;
import log.CSVLogger.*;

public class Main 
{
    public static void main(String[] args) throws IOException
    {
        Experiment[] experiments = {
            new Experiment(new SelectionSort(), "actg", 100),
            new Experiment(new MergeSort(), "actg", 100)
        };

        RuntimeLogger sumLogger;
        AverageLogger aveLogger;
        RawDataLogger rawLogger;
        
        for(Experiment experiment: experiments)
        {
            experiment.execute();
            
            sumLogger = new RuntimeLogger(experiment);
            aveLogger = new AverageLogger(experiment);
            rawLogger = new RawDataLogger(experiment);


            sumLogger.print();
            aveLogger.print();
            rawLogger.print();
        }
    }   
}
