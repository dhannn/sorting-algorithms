package core.sort.ConcreteSort;

import core.sequence.Sequence;
import core.sort.Sorter;

public class QuickSort extends Sorter 
{
    @Override
    public void sort(Sequence baseSequence, int[] suffixes) 
    {
        recurse_sort(baseSequence, suffixes, 0, suffixes.length - 1);
    }

    private void recurse_sort(Sequence baseSequence, int[] suffixes, int low, int high)
    {
        if (low < high) {
            int j = partition(baseSequence, suffixes, low, high);
            recurse_sort(baseSequence, suffixes, low, j - 1);
            recurse_sort(baseSequence, suffixes, j + 1, high);
        }
        
    }

    public int partition(Sequence baseSequence, int[] S, int low, int high) {
        int pivot = S[high];
        int left = low, right = high - 1;

        while (left < right) 
        {
             
            while (left < right && baseSequence.compareTo(S[left], pivot) < 0)
            {
                left++;
            }
            
            
            while (left < right && baseSequence.compareTo(S[right], pivot) > 0)
            {
                right--;
            }
            
            // if (left < right)
            swap(S, left, right);
        }

        // if(baseSequence.compareTo(S[left], S[high))

        if(baseSequence.compareTo(S[left], S[high]) > 0)
            swap(S, left, high);
        else 
            left = high;
        
        return left;
    }
}