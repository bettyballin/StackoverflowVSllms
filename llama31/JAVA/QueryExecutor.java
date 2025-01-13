import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class QueryExecutor {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
        EntityManager entityManager = emf.createEntityManager();

        QueryExecutor executor = new QueryExecutor(entityManager);
        executor.execute();

        entityManager.close();
        emf.close();
    }

    private EntityManager entityManager;

    public QueryExecutor(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void execute() {
        Query query = entityManager.createQuery("SELECT tab FROM tableA tab WHERE tab.colA IN (:colValues)");
        List<Integer> colValues = Arrays.asList(1, 2, 3);
        query.setParameter("colValues", colValues);
        // Add code here to execute the query and process the results
    }
}