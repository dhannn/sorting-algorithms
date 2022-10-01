package core.sort.ConcreteSort;

import core.sequence.Sequence;
import core.sort.Sorter;


public class SelectionSort extends Sorter
{
    @Override
    public void sort(Sequence baseSequence, int[] suffixes)
    {
        for(int i = 0; i < baseSequence.getLength(); i++)
        {
            int min = i;

            for(int j = i + 1; j < suffixes.length; j++)
            {
                String a = baseSequence.getSuffix(j);
                String b = baseSequence.getSuffix(min);
                
                if(compare(a, b) < 0)
                    min = j;
            }

            swap(suffixes, i, min);
        }
    }
}
