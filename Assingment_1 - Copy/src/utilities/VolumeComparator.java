package utilities;

import shapes.Shape;
import java.util.Comparator;    

public class VolumeComparator implements Comparator<Shape>
{
    public int compare(Shape s1, Shape s2)
    {
        return Double.compare(s1.getVolume(), s2.getVolume());
    }
}
