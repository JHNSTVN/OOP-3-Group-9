package utilities;

import shapes.Shape;
import java.util.Comparator;

public class SelectionSort
{
    public static void sort(Shape[] shapes, Comparator<Shape> comparator)
    {
        int n = shapes.length;
        for (int i = 0; i < n - 1; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < n; j++)
            {
                int cmp = (comparator == null)
                    ? shapes[j].compareTo(shapes[minIndex])
                    : comparator.compare(shapes[j], shapes[minIndex]);
                if (cmp < 0)
                {
                    minIndex = j;
                }
            }
            if (minIndex != i)
            {
                Shape temp = shapes[i];
                shapes[i] = shapes[minIndex];
                shapes[minIndex] = temp;
            }
        }
    }
}
