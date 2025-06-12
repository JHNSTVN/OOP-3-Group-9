package utilities;

import shapes.Shape;
import java.util.Comparator;

public class QuickSort {

    public static void sort(Shape[] shapes, Comparator<Shape> comparator) {
        quickSort(shapes, 0, shapes.length - 1, comparator);
    }

    private static void quickSort(Shape[] shapes, int low, int high, Comparator<Shape> comparator) {
        if (low < high) {
            int pivotIndex = medianOfThree(shapes, low, high, comparator);
            swap(shapes, pivotIndex, high); 

            int partitionIndex = partition(shapes, low, high, comparator);
            quickSort(shapes, low, partitionIndex - 1, comparator);
            quickSort(shapes, partitionIndex + 1, high, comparator);
        }
    }

    private static int partition(Shape[] shapes, int low, int high, Comparator<Shape> comparator) {
        Shape pivot = shapes[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(shapes[j], pivot) <= 0) {
                i++;
                swap(shapes, i, j);
            }
        }

        swap(shapes, i + 1, high);
        return i + 1;
    }

    private static int medianOfThree(Shape[] shapes, int low, int high, Comparator<Shape> comparator) {
        int mid = low + (high - low) / 2;

        Shape a = shapes[low];
        Shape b = shapes[mid];
        Shape c = shapes[high];

        if (comparator.compare(a, b) > 0) {
            if (comparator.compare(b, c) > 0)
                return mid;
            else if (comparator.compare(a, c) > 0)
                return high;
            else
                return low;
        } else {
            if (comparator.compare(a, c) > 0)
                return low;
            else if (comparator.compare(b, c) > 0)
                return high;
            else
                return mid;
        }
    }

    private static void swap(Shape[] shapes, int i, int j) {
        Shape temp = shapes[i];
        shapes[i] = shapes[j];
        shapes[j] = temp;
    }
}
