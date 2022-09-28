package core.Sort.ConcreteSort;

import core.Suffix;
import core.Sort.AbstractSort;

public class DummySort extends AbstractSort
{

    public DummySort() {}

    @Override
    public void sort(Suffix[] suffixes)
    {
        for(int i = 0; i < suffixes.length; i++)
        {
            int min = i;

            for(int j = i + 1; j < suffixes.length; j++)
            {
                if(suffixes[j].compareTo(suffixes[min]) < 0)
                {
                    min = j;
                }
            }

            Suffix temp = suffixes[i];
            suffixes[i] = suffixes[min];
            suffixes[min] = temp;
        }
    }
}
