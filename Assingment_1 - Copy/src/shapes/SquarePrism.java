package shapes;

public class SquarePrism extends Shape
{
    private double edgeLength;

    public SquarePrism(double edgeLength, double height) 
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
        // Area of a square prism = edgeLength^2
        return edgeLength * edgeLength;
    }
}
