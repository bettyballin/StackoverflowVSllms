/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Bank {
    private final CopyOnWriteArrayList<Account> accounts = new CopyOnWriteArrayList();

    public List<Account> getAccounts() {
        return this.accounts;
    }

    public static void main(String[] stringArray) {
    }
}
