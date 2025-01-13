/*
 * Decompiled with CFR 0.152.
 */
public static class TransactionDSL.Transaction {
    private String type;
    private double amount;
    private String fromAccount;
    private String toAccount;

    public TransactionDSL.Transaction(String string, double d, String string2, String string3) {
        this.type = string;
        this.amount = d;
        this.fromAccount = string2;
        this.toAccount = string3;
    }

    public static TransactionDSL.Transaction transfer(double d, String string, String string2) {
        return new TransactionDSL.Transaction("TRANSFER", d, string, string2);
    }

    public static TransactionDSL.Transaction deposit(double d, String string) {
        return new TransactionDSL.Transaction("DEPOSIT", d, null, string);
    }
}
