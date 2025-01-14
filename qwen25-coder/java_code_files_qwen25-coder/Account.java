import java.lang.String;
/**
 * Represents an Account in a banking system.
 */
public class Account {
    private double balance;

    /**
     * Deposits money into the account.
     * @param amount the amount of money to deposit
     */
    public void deposit(double amount) { /* method body */ }

    /**
     * Withdraws money from the account.
     * @param amount the amount of money to withdraw
     * @throws IllegalArgumentException if the amount is greater than balance
     */
    public void withdraw(double amount) throws IllegalArgumentException { /* method body */ }

	public static void main(String[] args) {
	}
}