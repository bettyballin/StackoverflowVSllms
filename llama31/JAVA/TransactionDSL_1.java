public class Transaction {
    private double amount;
    private String fromAccount;
    private String toAccount;

    public Transaction(double amount, String fromAccount, String toAccount) {
        this.amount = amount;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
    }

    public static Transaction transfer(double amount, String fromAccount, String toAccount) {
        return new Transaction(amount, fromAccount, toAccount);
    }
}

public class TransactionDSL_1_1 {
    Transaction transaction = Transaction.transfer(100.0, "AccountA", "AccountB");

    public static void main(String[] args) {
        new TransactionDSL_1();
    }
}