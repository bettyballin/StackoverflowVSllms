import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class EntityManagerUtil {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("your_persistence_unit");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT e FROM MyView e");
        List<MyEntity> results = query.getResultList();

        em.close();
        emf.close();
    }
}