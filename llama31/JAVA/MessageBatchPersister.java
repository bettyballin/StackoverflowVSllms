import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MessageBatchPersister {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("your_persistence_unit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        for (int i = 0; i < 100; i++) {
            Message message = new Message();
            // set message properties
            em.persist(message);
        }
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}