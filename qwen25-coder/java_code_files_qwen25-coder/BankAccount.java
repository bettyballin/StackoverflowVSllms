import java.lang.String;
public class BankAccount {
    // Private fields to store sensitive information
    private double balance;
    private String ownerName;

    // Constructor to initialize the bank account
    public BankAccount(String ownerName, double initialBalance) {
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    // Public method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Public method to withdraw money from the account
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Public method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Method to get the owner's name (could be secured further if needed)
    public String getOwnerName() {
        return ownerName;
    }

	public static void main(String[] args) {
	}
}