import java.util.*;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance , amount withdrawn more than balance!");
        }
        balance -= amount;
        System.out.println("Withdrawal successful and the new balance is: " + balance);
    }
}

public class BankTransactionSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the balance in your account: ");
            double initialBalance = scanner.nextDouble();
            BankAccount account = new BankAccount(initialBalance);

            System.out.print("Enter the withdrawal amount: ");
            double amount = scanner.nextDouble();

            account.withdraw(amount);
        } catch (InsufficientBalanceException e)
        {
            System.out.println(e.getMessage());
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e)
        {
            System.out.println("Please enter a valid input for the value.");
        }
        finally
        {
            scanner.close();
        }
    }
}
