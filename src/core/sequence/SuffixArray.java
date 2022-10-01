package core.sequence;

import core.sort.Sorter;
import lombok.Getter;

public class SuffixArray
{
    @Getter private Sorter sorter;
    @Getter private Sequence baseSequence;
    private int[] suffixArray;
    @Getter private final int length;

    public SuffixArray(Sorter sorter, Sequence sequence)
    {
        this.sorter = sorter;
        this.baseSequence = sequence;
        this.length = sequence.getLength();
        this.suffixArray = new int[length];
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
