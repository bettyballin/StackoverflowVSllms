import java.lang.String;
// This represents a simple bank account class with balance variable private, which can only be accessed through provided methods (methods here are publically visible but internals are kept private).
public class BankAccount {
    // Private balance. User has no direct access to this field.
    private double balance;

    // Public method for depositing money into the account.
    public void deposit(double amount) {
        if (amount > 0.0){
            balance += amount;
        } else {
            throw new IllegalArgumentException("Deposit must be greater than zero.");
        }
    }

    // Public method for withdrawing money from the account.
    public void withdraw(double amount) {
        if (amount <= balance){
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Withdrawal exceeds current balance.");
        }
    }

	public static void main(String[] args) {
	}
}