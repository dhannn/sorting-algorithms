package core.Sort.ConcreteSort;

import core.Suffix;
import core.Sort.AbstractSort;

public class SelectionSort extends AbstractSort
{

    public SelectionSort() {}

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

            suffixes[i].swap(suffixes[min]);
        }
    }
}
