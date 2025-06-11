package shapes;

public class OctagonalPrism extends Shape
{
private double edgeLength;

public OctagonalPrism(double edgeLength, double height)
{
    super(height);
    this.edgeLength = edgeLength;
}

@Override
public double getVolume()
{
    return getBaseArea() * height;
}

@Override
public double getBaseArea()
{
    return 2 * (1 + Math.sqrt(2)) * edgeLength * edgeLength;
}

}
