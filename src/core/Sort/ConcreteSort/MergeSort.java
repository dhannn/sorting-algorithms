package core.sort.ConcreteSort;

import core.sequence.Sequence;
import core.sort.Sorter;

public class MergeSort extends Sorter
{

    @Override
    public void sort(Sequence baseSequence, int[] suffixes) 
    {
        recurse_sort(baseSequence, suffixes, 0, suffixes.length - 1);   
    }

    private void recurse_sort(Sequence sequence, int[] A, int p, int r)
    {
        // base case
        if(p >= r) return;
        
        // divide
        int q = (p + r) / 2;
        // conquer
        this.recurse_sort(sequence, A, p, q);
        this.recurse_sort(sequence, A, q + 1, r);
        // combine
        this.merge(sequence, A, p, q, r);
    }

    private void merge(Sequence sequence, int[] A, int p, int q, int r)
    {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] A1 = new int[n1];
        int[] A2 = new int[n2];


        // populate the first half of the array (A1)
        for(int i = 0; i < n1; i++)
            A1[i] = A[p + i];
        
        // populate the first half of the array (A2)
        for(int i = 0; i < n2; i++)
            A2[i] = A[q + 1 + i];
        
        int i = 0, j = 0, k = p;
        
        while(i < n1 && j < n2)
        {
            int suffixI = A1[i];
            int suffixJ = A2[j];
            
            // checks which suffix is less
            if(sequence.compareTo(suffixI, suffixJ) <= 0)
            {
                A[k] = A1[i];
                i++;
            } else {
                A[k] = A2[j];
                j++;
            }
            k++;
        }

        for( ; i < n1; i++, k++)
            A[k] = A1[i];

        for( ; j < n2; j++, k++)
            A[k] = A2[j];
    }
}
