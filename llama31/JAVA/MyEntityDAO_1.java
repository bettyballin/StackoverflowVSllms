import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

// Assuming MyEntity is a properly defined JPA entity
public class MyEntityDAO_1_1 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("your_persistence_unit_name");
        EntityManager em = emf.createEntityManager();

        TypedQuery<MyEntity> query = em.createQuery("SELECT e FROM MyEntity e WHERE e.id = :id", MyEntity.class);
        query.setFlushMode(FlushModeType.COMMIT);
        // Assuming id is provided somehow
        query.setParameter("id", 1); // Set the id parameter
        MyEntity entity = query.getSingleResult();

        em.close();
        emf.close();
    }
}