// Abstraction
public interface Gearshift {
    void shiftGear(int gear);
}

// Information Hiding
public class SecureBankAccount {
    private String accountNumber;
    private String password;

    public void authenticate(String username, String password) {
        // Verify credentials
    }
}

// Encapsulation
public class BankAccount {
    private double balance;

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public static void main(String[] args) {
        // Create an instance of BankAccount to test the code
        BankAccount account = new BankAccount();
        account.deposit(1000);
        account.withdraw(500);
    }
}