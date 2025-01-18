import java.lang.String;
public class Account {
    protected double balance;

    public synchronized void withdraw(double value) {
        this.balance = this.balance - value;
    }

    public synchronized void deposit(double value) {
       this.balance +=  value;
    }

    public synchronized double getBalance() {
         return this.balance;
     }

	public static void main(String[] args) {
	}
}