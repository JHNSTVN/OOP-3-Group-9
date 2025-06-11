package utilities;

import shapes.Shape;
import java.util.Comparator;

public class InsertionSort 
{
    public static void sort(Shape[] shapes, Comparator<Shape> comparator) 
    {
        for (int i = 1; i < shapes.length; i++) 
        {
            Shape key = shapes[i];
            int j = i - 1;

            while (j >= 0 && compare(shapes[j], key, comparator) > 0) 
            {
                shapes[j + 1] = shapes[j];
                j--;
            }
            shapes[j + 1] = key;
        }
    }

    public static int compare(Shape a, Shape b, Comparator<Shape> comparator) 
    {
        return comparator == null ? a.compareTo(b) : comparator.compare(a, b);
    }
}
