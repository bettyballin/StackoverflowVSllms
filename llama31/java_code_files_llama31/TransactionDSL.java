/*
 * Decompiled with CFR 0.152.
 */
public class TransactionDSL {
    public static void main(String[] stringArray) {
    }

    public static class Transaction {
        private String type;
        private double amount;
        private String fromAccount;
        private String toAccount;

        public Transaction(String string, double d, String string2, String string3) {
            this.type = string;
            this.amount = d;
            this.fromAccount = string2;
            this.toAccount = string3;
        }

        public static Transaction transfer(double d, String string, String string2) {
            return new Transaction("TRANSFER", d, string, string2);
        }

        public static Transaction deposit(double d, String string) {
            return new Transaction("DEPOSIT", d, null, string);
        }
    }
}
