import java.util.List;
import java.util.ArrayList;

class Account {} // Added a basic Account class for compilation purposes

public class Bank_1_1 {
    private final List<Account> accounts = new ArrayList<>();

    public synchronized List<Account> getAccounts() {
        return accounts;
    }

    public synchronized void addAccount(Account account) {
        accounts.add(account);
    }

    public static void main(String[] args) {
    }
}