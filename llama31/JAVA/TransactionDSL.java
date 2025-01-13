import java.lang.String;
public class TransactionDSL {
    public static class Transaction {
        private String type;
        private double amount;
        private String fromAccount;
        private String toAccount;

        public Transaction(String type, double amount, String fromAccount, String toAccount) {
            this.type = type;
            this.amount = amount;
            this.fromAccount = fromAccount;
            this.toAccount = toAccount;
        }

        public static Transaction transfer(double amount, String fromAccount, String toAccount) {
            return new Transaction("TRANSFER", amount, fromAccount, toAccount);
        }

        public static Transaction deposit(double amount, String account) {
            return new Transaction("DEPOSIT", amount, null, account);
        }
    }

	public static void main(String[] args) {
	}
}