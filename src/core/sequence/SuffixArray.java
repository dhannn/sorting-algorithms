package core.sequence;

import core.sort.Sorter;
import lombok.Getter;

public class SuffixArray
{
    @Getter private Sorter sorter;
    @Getter private Sequence baseSequence;
    private int[] suffixArray;
    @Getter private final int length;

    public SuffixArray(Sorter sorter, String alphabet, int n)
    {
        this.sorter = sorter;
        this.length = n;
        this.baseSequence = new Sequence(alphabet, n);
        this.suffixArray = new int[n];
    }

    public String get(int i)
    {
        int suffixIndex = suffixArray[i];

        return baseSequence.getSuffix(suffixIndex);
    }

    public void sort()
    {
        sorter.sort(baseSequence, suffixArray);
    }
}
