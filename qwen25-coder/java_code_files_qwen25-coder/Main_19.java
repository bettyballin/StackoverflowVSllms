import java.lang.String;

public class Main_19 {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();
        Thread c1 = new Depositer(account);
        Thread c2 = new Withdrawer(account);

        c2.start();
        c1.start();

        // Wait for both threads to finish
        c1.join();
        c2.join();

        System.out.println("Final balance: " + account.getBalance());
    }
}

class Account {
    private int balance = 0;

    public synchronized void deposit(int amount) {
        balance += amount;
        notifyAll();
    }

    public synchronized void withdraw(int amount) throws InterruptedException {
        while (balance < amount) {
            wait();
        }
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}

class Depositer extends Thread {
    private Account account;

    public Depositer(Account account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            account.deposit(10);
            System.out.println("Deposited 10, balance is now: " + account.getBalance());
            try {
                Thread.sleep(100); // Simulate time taken to deposit
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Withdrawer extends Thread {
    private Account account;

    public Withdrawer(Account account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                account.withdraw(10);
                System.out.println("Withdrew 10, balance is now: " + account.getBalance());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(100); // Simulate time taken to withdraw
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}