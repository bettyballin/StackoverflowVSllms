import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class YourClassisprobablyUserSotheclassnamewouldbeUserDAOorsimilar {
    public static class YourClass {
        // Class definition
    }
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("YourPersistenceUnit");
        EntityManager entityManager = emf.createEntityManager();

        TypedQuery<YourClass> query = entityManager.createQuery(
            "FROM YourClass t WHERE CAST(t.active AS UNSIGNED) = :value", YourClass.class);
        query.setParameter("value", (Object) 1); // Or 0 if you're looking for inactive records
        List<YourClass> results = query.getResultList();
    }
}