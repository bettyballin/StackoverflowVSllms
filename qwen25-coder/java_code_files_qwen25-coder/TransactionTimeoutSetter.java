import java.lang.String;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.UserTransaction;
import javax.transaction.SystemException;

public class TransactionTimeoutSetter {
    // Example of setting transaction timeout in WAS admin console or programmatically
    public static void main(String[] args) {
        try {
            UserTransaction utx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
            utx.setTransactionTimeout(300); // Timeout in seconds
        } catch (NamingException | SystemException e) {
            e.printStackTrace();
        }
    }
}