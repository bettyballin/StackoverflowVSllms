// Define the BankAccount class
class BankAccount {
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Deposit method
    public void deposit(double amount) {
        balance += amount;
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    // Get balance method
    public double getBalance() {
        return balance;
    }
}

public class Main_534_534 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456789", 1000.0);
        account.deposit(500.0);
        account.withdraw(200.0);
        System.out.println("Account balance: " + account.getBalance());
    }
}