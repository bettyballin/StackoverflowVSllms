import javax.persistence.EntityManager;
import javax.persistence.Query;

public class BusinessRepository {
    EntityManager entityManager; // You need to initialize this

    public BusinessRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    Query query = entityManager.createQuery("select distinct b from Business b " +
            "left join fetch b.campaigns c " +
            "left join fetch c.promotions where b.id=:id");

    public static void main(String[] args) {
        // You need to create an EntityManager instance and pass it to BusinessRepository
        // This is usually done with an EntityManagerFactory
        // Here is a very simplified example, in real-world scenarios you'd likely use a framework like Spring
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("your-persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        BusinessRepository businessRepository = new BusinessRepository(entityManager);
    }
}