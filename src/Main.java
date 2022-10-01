import java.io.IOException;

import core.data.Experiment;
import core.sort.ConcreteSort.SelectionSort;
import log.AverageLogger;
import log.RuntimeLogger;

public class Main 
{
    public static void main(String[] args) throws IOException
    {
        Experiment testSelectionSort = new Experiment(new SelectionSort(), "actg", 30);
        testSelectionSort.execute();
        RuntimeLogger sumLogger = new RuntimeLogger(testSelectionSort);
        AverageLogger aveLogger = new AverageLogger(testSelectionSort);
        sumLogger.print();
        aveLogger.print();
    }   
}
