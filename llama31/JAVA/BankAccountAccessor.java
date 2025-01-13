import java.lang.String;

public class BankAccountAccessor {
    // Assuming 'prevayler' and 'Account' are defined elsewhere in the codebase
    // and 'Bank' is a subclass of 'Account'
    Account account = (Account) prevayler.prevalentSystem().getAccounts().get(2);

    public static void main(String[] args) {
        // You may want to create an instance of BankAccountAccessor here
        // to avoid the warning about the unused 'account' variable
        BankAccountAccessor accessor = new BankAccountAccessor();
        // Now you can use 'accessor.account'
    }
}