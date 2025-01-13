import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.TransactionManager;
import com.ibm.websphere.jtaextensions.ExtendedJTATransaction;

public class TransactionManagerSetup {
    
    public static void main(String[] args) {
        try {
            // Get the transaction manager
            TransactionManager tm = (TransactionManager) new InitialContext().lookup("java:comp/env/TransactionManager");
            
            // Enable extended transactional behavior
            ExtendedJTATransaction.enable(tm);
            System.out.println("Extended transactional behavior enabled.");
        } catch (NamingException e) {
            System.out.println("Error looking up TransactionManager: " + e.getMessage());
        }
    }
}