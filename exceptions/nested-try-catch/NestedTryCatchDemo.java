import java.util.*;

public class NestedTryCatchDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try
        {
            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();
            int[] array = new int[size];

            System.out.println("Enter " + size + " elements:");
            for (int i = 0; i < size; i++)
            {
                System.out.print("Enter the " + (i+1) + " element of the array: ");
                array[i] = scanner.nextInt();
            }
            System.out.println();
            System.out.print("Enter the index to access: ");
            int index = scanner.nextInt();

            try
            {
                System.out.print("Enter the divisor of fraction: ");
                int divisor = scanner.nextInt();

                int result = array[index] / divisor;
                System.out.println("Division result: " + result);
            }
            catch (ArithmeticException e)
            {
                System.out.println("Numerator cannot divide by zero!");
            }
        } catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Invalid array index!");
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
