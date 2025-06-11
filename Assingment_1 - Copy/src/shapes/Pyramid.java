package shapes;

public class Pyramid extends Shape 
{
    private double edgeLength;

    public Pyramid(double edgeLength, double height) 
    {
        super(height);
        this.edgeLength = edgeLength;
    }

    @Override
    public double getVolume() 
    {
        return (1.0 / 3.0) * getBaseArea() * height;
    }

    @Override
    public double getBaseArea() 
    {
        // Area of a square pyramid = edgeLength^2
        return edgeLength * edgeLength;
    }
}
