import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

class Account {}

public class Bank {
    private final CopyOnWriteArrayList<Account> accounts = new CopyOnWriteArrayList<>();

    public List<Account> getAccounts() {
        return accounts;
    }

    public static void main(String[] args) {
    }
}