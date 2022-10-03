package core.sort.ConcreteSort;

import core.sequence.Sequence;
import core.sort.Sorter;

/**
 * Concrete implementation of Sorter. It sorts suffixes based on a modified 
 * version of selection sort.
 */
public class SelectionSort extends Sorter
{
    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public void sort(Sequence baseSequence, int[] suffixes)
    {
        for(int i = 0; i < suffixes.length - 1; i++)
        {
            int min = i;

            for(int j = i + 1; j < suffixes.length; j++)
            {
                if(baseSequence.compareTo(suffixes[j], suffixes[min]) < 0)
                    min = j;
            }

            swap(suffixes, i, min);
        }
    }
}
