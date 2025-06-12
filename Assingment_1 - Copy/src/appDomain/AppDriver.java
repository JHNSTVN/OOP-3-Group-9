package appDomain;

import shapes.*;
import utilities.*;

import java.util.Comparator;

/*
 * Hello Hello, This is the main driver for our assignment.
 *
 * How to run the program:
 * - Open CMD in the project folder terminal, don't use powershell it was giving me troubles.
 * - Use the following commands to run the program (copy and paste as needed):
 *
 *   // Sort by volume using bubble sort (small, medium, large data sets)
 *   java -cp bin appDomain.AppDriver -fres/shapes1.txt -tv -sb
 *   java -cp bin appDomain.AppDriver -fres/shapes2.txt -tv -sb
 *   java -cp bin appDomain.AppDriver -fres/shapes3.txt -tv -sb
 *
 *   // Sort by base area using insertion sort (small, medium, large data sets)
 *   java -cp bin appDomain.AppDriver -fres/shapes1.txt -ta -si
 *   java -cp bin appDomain.AppDriver -fres/shapes2.txt -ta -si
 *   java -cp bin appDomain.AppDriver -fres/shapes3.txt -ta -si
 *
 *   // Sort by height using selection sort (small, medium, large data sets)
 *   java -cp bin appDomain.AppDriver -fres/shapes1.txt -th -ss
 *   java -cp bin appDomain.AppDriver -fres/shapes2.txt -th -ss
 *   java -cp bin appDomain.AppDriver -fres/shapes3.txt -th -ss
 *
 *   // Sort by volume using merge sort (small, medium, large data sets)
 *   java -cp bin appDomain.AppDriver -fres/shapes1.txt -tv -sm
 *   java -cp bin appDomain.AppDriver -fres/shapes2.txt -tv -sm
 *   java -cp bin appDomain.AppDriver -fres/shapes3.txt -tv -sm
 *
 * What do the do:
 *   -f<filename>   : The file to load shapes from
 *   -t<type>       : What to sort by: v = volume, a = base area, h = height 
 *   -s<sort>       : Which sort to use: b = bubble, i = insertion, s = selection, m = merge
 * 
 * The program loads shapes from the file, sorts them as you specify, and prints out the results.
 * I was also having issues with the large data sets, my computer could not handle them.
 * It wasn't crashing, but it was taking a long time to sort them, like very long.
 * 
 * - Johan
 */

public class AppDriver
{
    public static void main(String[] args)
    {
        String fileName = null; // The file with the shapes data
        Comparator<Shape> comparator = null; // How we compare shapes
        String sortType = null; // Which sorting algorithm to use

        // Step 1: Parse command-line arguments
        for (String arg : args)
        {
            arg = arg.toLowerCase();
            if (arg.startsWith("-f"))
            {
                fileName = arg.substring(2); // Get the filename after -f
            }
            else if (arg.startsWith("-t"))
            {
                // Figure out what we're sorting by
                char type = arg.charAt(2);
                if (type == 'v')
                    comparator = new VolumeComparator();
                else if (type == 'a')
                    comparator = new BaseAreaComparator();
                else if (type == 'h')
                    comparator = null; // Use default (height)
                else
                {
                    System.out.println("Invalid compare type: " + type);
                    return;
                }
            }
            else if (arg.startsWith("-s"))
            {
                sortType = arg.substring(2); // Get the sort type after -s
            }
        }

        // Step 2: Make sure we got what we need
        if (fileName == null || sortType == null)
        {
            System.out.println("Missing required arguments. Example: -fshapes1.txt -tv -sb");
            return;
        }

        // Step 3: Load shapes from the file
        Shape[] shapes = ShapeLoader.loadShapes(fileName);
        if (shapes.length == 0)
        {
            System.out.println("No shapes loaded.");
            return;
        }

        // Step 4: Sort the shapes and time how long it takes
        long startTime = System.nanoTime();

        switch (sortType)
        {
            case "b":
                BubbleSort.sort(shapes, comparator);
                break;
            case "i":
                InsertionSort.sort(shapes, comparator);
                break;
            case "s":
                SelectionSort.sort(shapes, comparator);
                break;
            case "m":
                MergeSort.sort(shapes, comparator);
                break;
            case "q":
                QuickSort.sort(shapes,comparator);
                break;
            default:
                System.out.println("Unsupported sort type: " + sortType);
                return;
        }

        long endTime = System.nanoTime();
        long durationMs = (endTime - startTime) / 1_000_000;

        // Step 5: Print out the results
        System.out.println("\nSort completed in " + durationMs + " ms.");
        // We print the first, last, and every 1000th shape (so you don't get spammed)
        for (int i = 0; i < shapes.length; i++)
        {
            if (i == 0 || i == shapes.length - 1 || i % 1000 == 0)
            {
                System.out.println(shapes[i]);
            }
        }
    }
}
