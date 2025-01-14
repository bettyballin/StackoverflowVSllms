import java.lang.String;
import javax.persistence.EntityManager;

public class ErrorCodeDAOImplassumingitsanimplementationofaDAOinterfaceegErrorCodeDAO {

    private EntityManager em;

    public ErrorCode findErrorCodeById(short id) {
        return (ErrorCode) em.createNamedQuery("ErrorCode.findByIdEager")
                .setParameter("id", id)
                .getSingleResult();
    }

    public static void main(String[] args) {
    }
}

class ErrorCode {
    // Empty class
}