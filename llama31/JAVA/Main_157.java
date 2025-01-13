import java.lang.String;

class Account {
    private int balance = 0;

    public synchronized void deposit(int amount) {
        balance += amount;
    }

    public synchronized void withdraw(int amount) {
        balance -= amount;
    }

    public synchronized int getBalance() {
        return balance;
    }
}

class Depositer extends Thread {
    private Account account;

    public Depositer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            account.deposit(1);
        }
    }
}

class Withdrawer extends Thread {
    private Account account;

    public Withdrawer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            account.withdraw(1);
        }
    }
}

public class Main_157_157 {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();
        Thread c1 = new Depositer(account);
        Thread c2 = new Withdrawer(account);

        c2.start();
        c1.start();

        c1.join();
        c2.join();

        System.out.println(account.getBalance());
    }
}