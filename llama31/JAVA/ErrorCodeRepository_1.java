import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityGraph;
import javax.persistence.Persistence;
import javax.persistence.QueryHints;
import javax.persistence.TypedQuery;

public class ErrorCodeRepository_1_1 {
    private EntityManager em;

    public ErrorCodeRepository_1() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("your_persistence_unit_name");
        em = emf.createEntityManager();
    }

    public ErrorCode findErrorCodeById(short id) {
        TypedQuery<ErrorCode> query = em.createNamedQuery("ErrorCode.findById", ErrorCode.class)
                .setParameter("id", id);
        EntityGraph<ErrorCode> graph = em.createEntityGraph(ErrorCode.class);
        graph.addAttributeNodes("your_lazy_field"); // Add all fields you want to fetch eagerly
        query.setHint(QueryHints.FETCH_GRAPH, graph);
        return query.getSingleResult();
    }

    public static void main(String[] args) {
        ErrorCodeRepository_1 repository = new ErrorCodeRepository_1();
        // Use the repository to find an ErrorCode by ID
        ErrorCode errorCode = repository.findErrorCodeById((short) 1);
        // Do something with the ErrorCode
    }
}