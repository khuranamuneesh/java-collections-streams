import java.util.*;

public class ArrayOperationsException
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        try
        {
            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();
            Integer[] array = new Integer[size];

            System.out.println("Enter " + size + " elements in array:");
            for (int i = 0; i < size; i++)
            {
                array[i] = scanner.nextInt();
            }

            System.out.print("Enter the index value to retrieve value: ");
            int index = scanner.nextInt();

            System.out.println("Value at index " + index + ": " + array[index]);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Invalid index!");
        }
        catch (NullPointerException e)
        {
            System.out.println("Array is not initialized!");
        }
        catch (InputMismatchException e)
        {
            System.out.println("Error: Please enter valid integer values.");
        }
        finally
        {
            scanner.close();
        }
    }
}
