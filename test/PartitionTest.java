package test;

import static org.junit.Assert.assertArrayEquals;

import java.util.stream.IntStream;

import org.junit.Test;

import core.sequence.Sequence;
import core.sort.ConcreteSort.QuickSort;

public class PartitionTest 
{
    @Test
    public void basicTest()
    {
        Sequence sequence = new Sequence("", 6);
        sequence.setSequence("febdac");

        QuickSort sorter = new QuickSort();
        int[] s = IntStream.range(0, sequence.getLength()).toArray();

        sorter.partition(sequence, s, 0, s.length - 1);


        int[] expected = {4, 2, 5, 3, 0, 1};
        assertArrayEquals(null, expected, s);
        //
    }
    @Test
    public void edgeCaseTest()
    {
        Sequence sequence = new Sequence("", 4);
        sequence.setSequence("tcta");

        QuickSort sorter = new QuickSort();
        int[] s = IntStream.range(0, sequence.getLength()).toArray();

        sorter.sort(sequence, s);

        int[] expected = {3, 1, 2, 0};
        assertArrayEquals(null, expected, s);
        //gagtagca
    }
    
    @Test
    public void edgeCaseTest2()
    {
        Sequence sequence = new Sequence("", 4);
        sequence.setSequence("agcc");

        QuickSort sorter = new QuickSort();
        int[] s = IntStream.range(0, sequence.getLength()).toArray();

        sorter.sort(sequence, s);

        int[] expected = {0, 3, 2, 1};
        assertArrayEquals(null, expected, s);
        //gagtagca
    }
    
    @Test
    public void edgeCaseTest4()
    {
        Sequence sequence = new Sequence("", 4);
        sequence.setSequence("ccag");

        QuickSort sorter = new QuickSort();
        int[] s = IntStream.range(0, sequence.getLength()).toArray();

        sorter.sort(sequence, s);

        int[] expected = {2, 1, 0, 3};
        assertArrayEquals(null, expected, s);
        //gagtagca
    }
    
    @Test
    public void edgeCaseTest5()
    {
        Sequence sequence = new Sequence("", 4);
        sequence.setSequence("acat");

        QuickSort sorter = new QuickSort();
        int[] s = IntStream.range(0, sequence.getLength()).toArray();

        sorter.sort(sequence, s);

        int[] expected = {0, 2, 1, 3};
        assertArrayEquals(null, expected, s);
        //gagtagca
    }

    //ccag
}
