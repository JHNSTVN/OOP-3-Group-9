package utilities;

import shapes.Shape;
import java.util.Comparator;

public class MergeSort
{
    // Public method to start merge sort
    public static void sort(Shape[] arr, Comparator<Shape> comparator)
    {
        if (arr == null || arr.length <= 1)
            return;
        mergeSort(arr, 0, arr.length - 1, comparator);
    }

    // Recursive merge sort
    private static void mergeSort(Shape[] arr, int left, int right, Comparator<Shape> comparator)
    {
        if (left < right)
        {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, comparator);
            mergeSort(arr, mid + 1, right, comparator);
            merge(arr, left, mid, right, comparator);
        }
    }

    // Merge two sorted halves
    private static void merge(Shape[] arr, int left, int mid, int right, Comparator<Shape> comparator)
    {
        int size1 = mid - left + 1;
        int size2 = right - mid;

        Shape[] leftArr = new Shape[size1];
        Shape[] rightArr = new Shape[size2];

        System.arraycopy(arr, left, leftArr, 0, size1);
        System.arraycopy(arr, mid + 1, rightArr, 0, size2);

        int i = 0, j = 0, k = left;

        while (i < size1 && j < size2)
        {
            if (compare(leftArr[i], rightArr[j], comparator) <= 0)
            {
                arr[k++] = leftArr[i++];
            }
            else
            {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < size1)
            arr[k++] = leftArr[i++];
        while (j < size2)
            arr[k++] = rightArr[j++];
    }

    // Helper to handle null comparator
    private static int compare(Shape a, Shape b, Comparator<Shape> comparator)
    {
        return comparator == null ? a.compareTo(b) : comparator.compare(a, b);
    }
}
