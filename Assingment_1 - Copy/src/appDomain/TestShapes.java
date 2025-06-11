package appDomain;

import shapes.Cylinder;
import shapes.Cone;
import shapes.OctagonalPrism;
import shapes.PentagonalPrism;
import shapes.Pyramid;
import shapes.SquarePrism;
import shapes.TriangularPrism;
import utilities.BaseAreaComparator;
import utilities.BubbleSort;
import utilities.VolumeComparator;
/*
 * This is just my test class to test the shapes and sorting functionality.
 * It creates instances of various shapes, prints them, sorts them by volume and base area,
 * and prints the sorted results.
 * To run this, make sure you have the shapes and utilities packages set up correctly.
 * You can run this class directly, and it will output the shapes and their sorted order.
 * Right click on the file and press run java.
 * * Note: This is not part of the assignment requirements, but just for testing purposes.
 * We can remove it later if needed.
 */

public class TestShapes {
    public static void main(String[] args) 
    {
        Cylinder c = new Cylinder(10, 3);
        Cone cone = new Cone(10, 3);
        OctagonalPrism octagonalPrism = new OctagonalPrism(10, 5);
        PentagonalPrism pentagonalPrism = new PentagonalPrism(10, 5);
        Pyramid pyramid = new Pyramid(10, 5);
        SquarePrism squarePrism = new SquarePrism(10, 5);
        TriangularPrism triangularPrism = new TriangularPrism(10, 5);
        

        System.out.println("cylinder: " + c);
        System.out.println("cone: " + cone);
        System.out.println("octagonal prism: " + octagonalPrism);
        System.out.println("pentagonal prism: " + pentagonalPrism);
        System.out.println("pyramid: " + pyramid);
        System.out.println("square prism: " + squarePrism);
        System.out.println("triangular prism: " + triangularPrism);


        // Create an array of shapes
        shapes.Shape[] shapes = 
        {
            c, cone, octagonalPrism, pentagonalPrism, pyramid, squarePrism, triangularPrism
        };

        // Sort the shapes by volume using BubbleSort and VolumeComparator
        BubbleSort.sort(shapes, new VolumeComparator());

        // Print the sorted shapes
        System.out.println("\nSorted shapes by volume:");
        for (shapes.Shape s : shapes) 
        {
            System.out.println(s);
        }

        BubbleSort.sort(shapes, new BaseAreaComparator());

        // Print the sorted shapes by base area
        System.out.println("\nSorted shapes by base area:");
        for (shapes.Shape s : shapes) 
        {
            System.out.println(s);
        }
    }
}

