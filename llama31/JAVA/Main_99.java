import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main_99 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("feature1");
        EntityManager em = emf.createEntityManager();

        // Use the EntityManager to interact with the database
        // For example, to retrieve all Entity1 instances:
        // em.createQuery("SELECT e FROM Entity1 e", Entity1.class).getResultList();

        em.close();
        emf.close();
    }
}