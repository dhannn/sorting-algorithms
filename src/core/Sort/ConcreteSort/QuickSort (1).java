/**
 * Notes:
 * Sequence is an object that contains the sequence of words and the length
 * There is a sequence in a suffix array (baseSequence)
 * the suffix array contains an integer array
 * 
 */

public class QuickSort extends AbstractSort {

    public void sort(Sequence baseSequence, int[] suffixes, int low, int high) {
        if (low < high) {
            int j = Partition(baseSequence, suffixes, low, high);
            QuickSort(baseSequence, suffixes, low, j);
            QuickSort(baseSequence, suffixes, j + 1, high);
        }
    }

    public int partition(Sequence baseSequence, int[] suffixes, int low, int high) {
        int pivot = high;
        int leftIndex = low, rightIndex = high - 1;

        while (leftIndex < rightIndex) {
            if (baseSequence.compareTo(pivot, leftIndex) < 0)
                leftIndex++;

            if (baseSequence.compareTo(pivot, rightIndex) > 0)
                rightIndex--;

            if (leftIndex < rightIndex)
                swap(suffixes, leftIndex, rightIndex);
        }

        swap(suffixes, leftIndex, pivot);
        return rightIndex;
    }
}