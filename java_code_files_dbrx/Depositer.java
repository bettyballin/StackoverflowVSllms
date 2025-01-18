import java.lang.String;

class Account {
    public void deposit(int amount) {
        // Do nothing
    }
}

public class Depositer extends Thread {
    protected Account account;

    public Depositer(Account a) {
        account = a;
    }

    @Override
    public void run()  {
        for(int i = 0; i < 1000; i++) {
            this.account.deposit(10);
        }
    }

    public static void main(String[] args) {
    }
}