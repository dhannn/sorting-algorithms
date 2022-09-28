import java.io.IOException;

import core.Sort.SortTester;
import core.Sort.ConcreteSort.DummySort;
import log.RawDataLogger;
import log.SummaryLogger;

public class Main 
{
    public static void main(String[] args) throws IOException
    {
        SortTester test = new SortTester(new DummySort(), "actg", 10);
        test.execute();

        RawDataLogger rdLogger = new RawDataLogger(test);
        SummaryLogger sumLogger = new SummaryLogger(test);

        rdLogger.print();
        sumLogger.print();
    }   
}
