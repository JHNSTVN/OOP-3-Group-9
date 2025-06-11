package shapes;

public class TriangularPrism extends Shape
{
    private double edgeLength;

    public TriangularPrism(double edgeLength, double height) 
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
        // Area of an equilateral triangle = (sqrt(3) / 4) * edgeLength^2
        return (Math.sqrt(3) / 4) * edgeLength * edgeLength;
    }
}
