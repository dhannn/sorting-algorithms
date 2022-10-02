public class QuickSort {

    public void QuickSort(int low, int high, String A[]) {
        if (l < h) {
            int j = Partition(A, low, high);
            QuickSort(low, j);
            QuickSort(j + 1, high);
        }
    }

    public int Partition(String A[], int low, int high) {
        int pivot = high;
        int leftIndex = low, rightIndex = high - 1;

        while (leftIndex < rightIndex) {
            if (A[leftIndex].compareTo(A[pivot]) < 0)
                leftIndex++;

            if (A[leftIndex].compareTo(A[pivot]) > 0)
                rightIndex--;

            if (A[leftIndex].compareTo(A[rightIndex]) < 0)
                swap(A, leftIndex, rightIndex);
        }

        swap(A, leftIndex, pivot);
        return rightIndex;
    }
}