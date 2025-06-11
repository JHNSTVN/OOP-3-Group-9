package utilities;

import shapes.*;

import java.io.*;
import java.util.*;

public class ShapeLoader
{
    public static Shape[] loadShapes(String filePath)
    {
        ArrayList<Shape> shapeList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            int shapeCount = Integer.parseInt(reader.readLine());

            for (int i = 0; i < shapeCount; i++)
            {
                String line = reader.readLine();
                if (line == null)
                    break;

                String[] parts = line.split(" ");
                String type = parts[0];
                double height = Double.parseDouble(parts[1]);
                double value = Double.parseDouble(parts[2]);

                Shape shape;

                switch (type.toLowerCase())
                {
                    case "cylinder":
                        shape = new Cylinder(height, value);
                        break;
                    case "cone":
                        shape = new Cone(height, value);
                        break;
                    case "pyramid":
                        shape = new Pyramid(height, value);
                        break;
                    case "squareprism":
                        shape = new SquarePrism(height, value);
                        break;
                    case "triangularprism":
                        shape = new TriangularPrism(height, value);
                        break;
                    case "pentagonalprism":
                        shape = new PentagonalPrism(height, value);
                        break;
                    case "octagonalprism":
                        shape = new OctagonalPrism(height, value);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown shape type: " + type);
                }

                shapeList.add(shape);
            }
        }
        catch (IOException | NumberFormatException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
            return new Shape[0];
        }

        return shapeList.toArray(new Shape[0]);
    }
}
