import java.util.*;

public class FinallyExceptionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try
        {
            System.out.print("Enter the numerator: ");
            int numerator = scanner.nextInt();

            System.out.print("Enter the denominator: ");
            int denominator = scanner.nextInt();

            int result = numerator / denominator;
            System.out.println("Result of the division: " + result);
        }
        catch (ArithmeticException e)
        {
            System.out.println("Arithmetic Error: Division by zero is not allowed.");
        }
        catch (InputMismatchException e)
        {
            System.out.println("Input Error: Please enter valid integer values.");
        }
        finally
        {
            System.out.println("Operation completed.");
            scanner.close();
        }
    }
}
