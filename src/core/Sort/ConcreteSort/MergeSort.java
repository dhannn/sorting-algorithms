package core.Sort.ConcreteSort;

import core.Suffix;
import core.Sort.AbstractSort;

public class MergeSort extends AbstractSort 
{

    @Override
    public void sort(Suffix[] suffixes) 
    {
        recurse_sort(suffixes, 0, suffixes.length - 1);   
    }

    private void recurse_sort(Suffix[] A, int p, int r)
    {
        if(p >= r) return;
        
        int q = (p + r) / 2;
        this.recurse_sort(A, p, q);
        this.recurse_sort(A, q + 1, r);
        this.merge(A, p, q, r);
    }

    private void merge(Suffix[] A, int p, int q, int r)
    {
        int n1 = q - p + 1;
        int n2 = r - q;

        Suffix[] A1 = new Suffix[n1];
        Suffix[] A2 = new Suffix[n2];

        for(int i = 0; i < n1; i++)
            A1[i] = A[p + i];
        
        for(int i = 0; i < n2; i++)
            A2[i] = A[q + 1 + i];

        int i = 0, j = 0, k = p;

        while(i < n1 && j < n2)
        {
            if(A1[i].compareTo(A2[j]) <= 0)
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
