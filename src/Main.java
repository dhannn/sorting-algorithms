import java.io.IOException;

import core.data.Experiment;
import core.sort.ConcreteSort.MergeSort;
import core.sort.ConcreteSort.SelectionSort;
// import log.RawDataLogger;
// import log.CSVLogger.AverageLogger;
// import log.CSVLogger.RuntimeLogger;
import log.RawDataLogger;
import log.CSVLogger.*;;

public class Main 
{
    public static void main(String[] args) throws IOException
    {
        Experiment testSelectionSort = new Experiment(new MergeSort(), "actg", 100);
        testSelectionSort.execute();
        RuntimeLogger sumLogger = new RuntimeLogger(testSelectionSort);
        AverageLogger aveLogger = new AverageLogger(testSelectionSort);
        RawDataLogger rawLogger = new RawDataLogger(testSelectionSort);
        sumLogger.print();
        aveLogger.print();
        rawLogger.print();
    }   
}
