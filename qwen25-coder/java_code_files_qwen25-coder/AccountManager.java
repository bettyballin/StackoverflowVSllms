import java.lang.String;

public class AccountManager {
    static Prevayler prevayler;
    Account account = (Bank)prevayler.prevalentSystem().getAccounts().get(2);
    public static void main(String[] args) {
    }
}

class Prevayler {
    public PrevalentSystem prevalentSystem() {
        return new PrevalentSystem();
    }
}

class PrevalentSystem {
    public Accounts getAccounts() {
        return new Accounts();
    }
}

class Accounts {
    public Account get(int index) {
        return new Account();
    }
}

class Account {
}

class Bank extends Account {
}