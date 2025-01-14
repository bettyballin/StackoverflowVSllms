import java.lang.String;
public class Account_1 {
    final class Account {
        private final String accountNumber;
        private double balance;

        public Account(String accountNumber, double initialBalance) {
            this.accountNumber = accountNumber;
            this.balance = initialBalance;
        }

        public final void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }

        public final boolean withdraw(double amount) {
            if (amount > balance || amount < 0) {
                return false;
            }
            balance -= amount;
            return true;
        }

        // Other methods as necessary...
    }
    public static void main(String[] args) {
    }
}