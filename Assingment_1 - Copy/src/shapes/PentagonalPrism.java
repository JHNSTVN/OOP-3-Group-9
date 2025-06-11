package shapes;

public class PentagonalPrism extends Shape
{
private double edgeLength;

public PentagonalPrism(double edgeLength, double height)
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
    // Area of a regular pentagon = (sqrt(5(5 + 2sqrt(5)))) / 4 * edgeLength^2
    return (Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) / 4) * edgeLength * edgeLength;
}
}