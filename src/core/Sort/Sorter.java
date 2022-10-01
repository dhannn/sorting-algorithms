package core.sort;

import core.sequence.Sequence;

public abstract class Sorter
{
    public abstract void sort(Sequence baseSequence, int[] suffixes);
    
    public static void swap(int[] suffixes, int a, int b)
    {
        int temp = suffixes[a];
        
        suffixes[a] = suffixes[b];
        suffixes[b] = temp;
    }

    public static int compare(Sequence sequence, int[] suffixes, int a, int b)
    {
        int indexA = suffixes[a];
        int indexB = suffixes[b];

        String strA = sequence.getSuffix(indexA);
        String strB = sequence.getSuffix(indexB);

        return strA.compareToIgnoreCase(strB);
    }

    public static int compare(String a, String b)
    {
        return a.compareToIgnoreCase(b);
    }
}
