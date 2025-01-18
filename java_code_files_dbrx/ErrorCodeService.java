import java.lang.String;
import javax.persistence.EntityManager;
import javax.persistence.EntityGraph;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

public class ErrorCodeService {
    @PersistenceContext(unitName = "PersistenceUnit", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;
    
    public ErrorCode findErrorCodeByIdWithEagerFetching(short id) {
        EntityGraph<?> graph = em.getEntityGraph("graph.findById"); // Define your entity graph first

        TypedQuery<SomeEntity> query = em.createNamedQuery("ErrorCode.findById", SomeEntity.class);
        query.setParameter("id", id);
        return (ErrorCode) query.setHint("javax.persistence.loadgraph", graph).getSingleResult();
    }
    
    public static void main(String[] args) {
    }
}

class ErrorCode {
    // Empty class to allow compilation
}

class SomeEntity {
    // Empty class to allow compilation
}