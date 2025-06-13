package utilities;

import shapes.Shape;
import java.util.Comparator;

public class HeapSort {

    public static void sort(Shape[] shapes, Comparator<Shape> comparator) {
        int n = shapes.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(shapes, n, i, comparator);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(shapes, 0, i); 
            heapify(shapes, i, 0, comparator);
        }
    }

    private static void heapify(Shape[] shapes, int n, int i, Comparator<Shape> comparator) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && comparator.compare(shapes[left], shapes[smallest]) < 0) {
            smallest = left;
        }

        if (right < n && comparator.compare(shapes[right], shapes[smallest]) < 0) {
            smallest = right;
        }

        if (smallest != i) {
            swap(shapes, i, smallest);
            heapify(shapes, n, smallest, comparator);
        }
    }

    private static void swap(Shape[] shapes, int i, int j) {
        Shape temp = shapes[i];
        shapes[i] = shapes[j];
        shapes[j] = temp;
    }
}