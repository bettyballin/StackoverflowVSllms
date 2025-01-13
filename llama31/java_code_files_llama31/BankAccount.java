/*
 * Decompiled with CFR 0.152.
 */
public class BankAccount {
    private double balance;
    private String accountNumber;

    public BankAccount(String string, double d) {
        this.accountNumber = string;
        this.balance = d;
    }

    public void deposit(double d) {
        if (d > 0.0) {
            this.balance += d;
        }
    }

    public void withdraw(double d) {
        if (d > 0.0 && this.balance >= d) {
            this.balance -= d;
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public static void main(String[] stringArray) {
    }
}
