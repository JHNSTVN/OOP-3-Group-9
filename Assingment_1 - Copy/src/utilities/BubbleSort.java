package utilities;

import shapes.Shape;
import java.util.Comparator;    

public class BubbleSort 
{
    public static void sort(Shape[] shapes, Comparator<Shape> comparator) 
    {
        boolean swapped;
        int n = shapes.length; 

        for (int i = 0; i < n - 1; i++) 
        {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) 
            {
                if (comparator.compare(shapes[j], shapes[j + 1]) > 0) 
                {
                    Shape temp = shapes[j];
                    shapes[j] = shapes[j + 1];
                    shapes[j + 1] = temp;
                    swapped = true;
               
                }
            }
            if (!swapped) 
                break;
        }
    }
}
