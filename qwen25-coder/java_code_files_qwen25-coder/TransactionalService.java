import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@WebService
public interface TransactionalService {
    @WebMethod
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    void performAtomicOperation() throws Exception;
}

public class TransactionalServiceImpl implements TransactionalService {
    public static void main(String[] args) {
        // Main method implementation
    }

    @Override
    public void performAtomicOperation() throws Exception {
        // Method implementation
    }
}