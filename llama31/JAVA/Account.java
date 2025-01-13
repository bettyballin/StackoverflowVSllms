import java.lang.String;

// Domain object with rich behavior
public class Account {
    public void mergeWith(Account otherAccount) {
        // implementation
    }
}

// Service layer that uses domain objects
public class AccountService {
    public void mergeAccounts(Account mainAccount, Account lesserAccount) {
        mainAccount.mergeWith(lesserAccount);
        // handle save and delete logic
    }

    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        Account mainAccount = new Account();
        Account lesserAccount = new Account();
        accountService.mergeAccounts(mainAccount, lesserAccount);
    }
}