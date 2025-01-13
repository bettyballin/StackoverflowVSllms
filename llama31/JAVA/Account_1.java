import java.lang.String;

// Domain object with rich behavior
public class Account_1 {
    public void mergeWith(Account otherAccount) {
        // implementation
    }
}

// Repository that encapsulates data access and manipulation logic
public class Account_1Repository {
    public void save(Account account) {
        // implementation
    }

    public void delete(Account account) {
        // implementation
    }
}

// Service layer that uses domain objects and repository
public class Account_1Service {
    private AccountRepository repository;

    public void mergeAccounts(Account mainAccount, Account lesserAccount) {
        mainAccount.mergeWith(lesserAccount);
        repository.save(mainAccount);
        repository.delete(lesserAccount);
    }

    public static void main(String[] args) {
        Account account1 = new Account();
        Account account2 = new Account();
        AccountRepository repository = new AccountRepository();
        AccountService service = new AccountService();
        service.repository = repository;
        service.mergeAccounts(account1, account2);
    }
}