import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EntityRetriever_1_1 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("your_persistence_unit_name");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Query query = em.createQuery("SELECT e FROM MyEntity e WHERE e.id = :id");
        query.setFlushMode(FlushModeType.COMMIT);
        // Assuming id is 1 for demonstration purposes
        query.setParameter("id", 1);
        MyEntity entity = (MyEntity) query.getSingleResult();

        tx.commit();
        em.close();
        emf.close();
    }
}