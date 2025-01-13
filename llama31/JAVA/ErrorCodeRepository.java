import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.QueryHints;

public class ErrorCodeRepository {
    private EntityManager em; // You need to initialize this EntityManager

    public ErrorCode findErrorCodeById(short id) {
        Query query = em.createNamedQuery("ErrorCode.findById")
                .setParameter("id", id)
                .setHint(QueryHints.FETCH, "javax.persistence.fetchgraph");
        return (ErrorCode) query.getSingleResult();
    }

    public static void main(String[] args) {
        // You need to create an instance of ErrorCodeRepository and call findErrorCodeById
        // ErrorCodeRepository repository = new ErrorCodeRepository();
        // ErrorCode errorCode = repository.findErrorCodeById((short) 1);
    }
}