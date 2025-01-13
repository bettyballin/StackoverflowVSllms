import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class MyEntityDAO {
    String searchTerm = "acido";
    EntityManager entityManager;

    public MyEntityDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("your_persistence_unit_name");
        entityManager = emf.createEntityManager();
    }

    public void findMyEntityByWord() {
        Query query = entityManager.createNamedQuery("findMyEntityByWord")
                .setParameter("word", "%" + searchTerm + "%");
        List<MyEntity> results = query.getResultList();
        // Process the results
    }

    public static void main(String[] args) {
        MyEntityDAO myEntityDAO = new MyEntityDAO();
        myEntityDAO.findMyEntityByWord();
    }
}