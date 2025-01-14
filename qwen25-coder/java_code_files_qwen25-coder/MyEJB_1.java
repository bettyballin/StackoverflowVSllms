import java.lang.String;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
public class MyEJB_1 {
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void doBusiness() {
        // Business logic here
    }

    public static void main(String[] args) {
    }
}