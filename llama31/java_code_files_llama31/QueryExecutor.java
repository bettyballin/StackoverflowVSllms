/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.EntityManager
 *  javax.persistence.EntityManagerFactory
 *  javax.persistence.Persistence
 *  javax.persistence.Query
 */
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class QueryExecutor {
    private EntityManager entityManager;

    public static void main(String[] stringArray) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory((String)"example-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        QueryExecutor queryExecutor = new QueryExecutor(entityManager);
        queryExecutor.execute();
        entityManager.close();
        entityManagerFactory.close();
    }

    public QueryExecutor(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void execute() {
        Query query = this.entityManager.createQuery("SELECT tab FROM tableA tab WHERE tab.colA IN (:colValues)");
        List<Integer> list = Arrays.asList(1, 2, 3);
        query.setParameter("colValues", list);
    }
}
