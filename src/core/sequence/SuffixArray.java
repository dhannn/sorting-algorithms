package core.sequence;

import java.util.stream.IntStream;

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
        this.suffixArray = IntStream.range(0, length).toArray();
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

    @Override
    public String toString()
    {
        StringBuilder strBuilder = new StringBuilder();

        int digits = Integer.toString(baseSequence.getLength()).length();
        
        for(int index: suffixArray)
        {
            String format = "%" + digits + "d: %s\n";

            strBuilder.append(String.format(format, index, baseSequence.getSuffix(index)));
        }

        return strBuilder.toString();
    }
}
