import java.lang.String;

class Account {
    private int balance = 10000;

    public synchronized void withdraw(int amount) {
        balance -= amount;
    }
}

public class Withdrawer extends Thread {
    protected Account account;

    public Withdrawer(Account a) {
         account = a;
    }

     @Override
      public void run()   {
          for ( int i=0 ;  i<  1000;   i++)   {
             this.account.withdraw(10);
           }
    }

	public static void main(String[] args) {
	}
}