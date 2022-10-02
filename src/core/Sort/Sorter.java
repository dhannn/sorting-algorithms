package core.sort;

import core.sequence.Sequence;

/**
 * An abstract class that sorts the suffixes of a given base sequence.
 */
public abstract class Sorter
{
    /**
     * Uses the baseSequence to sort the suffixes and store the result in an array
     * 
     * @param baseSequence
     * @param suffixes
     */
    public abstract void sort(Sequence baseSequence, int[] suffixes);
    
    /**
     * Swaps two elements in array of suffixes
     * 
     * @param suffixes  integer representation of the suffix (i.e starting index)
     * @param a         index of first element to be swapped
     * @param b         index of second element to be swapped
     */
    public static void swap(int[] suffixes, int a, int b)
    {
        int temp = suffixes[a];
        
        suffixes[a] = suffixes[b];
        suffixes[b] = temp;
    }
}
