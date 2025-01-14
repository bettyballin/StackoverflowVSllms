public class BankProxy {

    private Prevayler prevayler;

    public synchronized Account getAccount(int index) {
        return (Bank)prevayler.prevalentSystem().getAccounts().get(index);
    }

    // Within a transaction:
    public void someTransaction(Account account) {
        synchronized(this) {  // Ensure the lock is on the same object
            // Modify accounts here...
        }
    }

    public static void main(String[] args) {
    }

}

class Account {
    // Minimal definition
}

class Bank extends Account {
    // Minimal definition
}

class Prevayler {
    public PrevalentSystem prevalentSystem() {
        return new PrevalentSystem();
    }
}

class PrevalentSystem {
    public java.util.List<Account> getAccounts() {
        return new java.util.ArrayList<Account>();
    }
}