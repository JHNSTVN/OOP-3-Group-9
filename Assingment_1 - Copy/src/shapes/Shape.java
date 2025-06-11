package shapes;

public abstract class Shape implements Comparable<Shape> 
{
    protected double height;

    public Shape(double height) 
    {
        this.height = height;
    }

    public double getHeight()
    {
        return height;
    }

    public abstract double getVolume();
    public abstract double getBaseArea();

    @Override
    public int compareTo(Shape other) 
    {
        return Double.compare(this.height, other.height);
    }

    @Override
    public String toString() 
    {
        return String.format("%s [height=%.2f, basearea=%.2f, volume=%.2f]", 
                              this.getClass().getSimpleName(), 
                              getHeight(), getBaseArea(), getVolume());
    }
}
