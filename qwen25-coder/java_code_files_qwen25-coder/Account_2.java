import java.math.BigDecimal;

// Example of a simple Account class with encapsulated business logic
public class Account_2 {
    private String id;
    private BigDecimal balance = BigDecimal.ZERO;

    public Account_2() {
    }

    public void deposit(BigDecimal amount) {
        // Business logic here...
        this.balance = this.balance.add(amount);
    }

    public boolean validate() {
        // Additional validation logic...
        return true;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}

// Service layer orchestrating operations across multiple objects or systems
public class Account_2Service {
    private AccountRepository accountRepository;

    public Account_2Service(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void merge(String mainAccountId, String lesserAccountId) {
        Account_2 mainAccount = accountRepository.findById(mainAccountId);
        Account_2 lesserAccount = accountRepository.findById(lesserAccountId);

        // Business logic that spans multiple accounts
        if (mainAccount.validate() && lesserAccount.validate()) {
            mainAccount.deposit(lesserAccount.getBalance()); // Leveraging encapsulated business logic
            accountRepository.delete(lesserAccount);
            accountRepository.save(mainAccount);
        }
    }
}

// AccountRepository interface
interface AccountRepository {
    Account_2 findById(String accountId);
    void delete(Account_2 account);
    void save(Account_2 account);
}

// DTO for inter-service communication
public class Account_2DTO {
    private String id;
    private BigDecimal balance;

    // Getters and setters

    public static void main(String[] args) {
    }
}