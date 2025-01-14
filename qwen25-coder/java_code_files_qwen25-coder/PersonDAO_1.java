import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class PersonDAO_1 {
    private final EntityManagerFactory emf;

    public PersonDAO_1(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<Person> findPersonByName(String name) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            return entityManager.createQuery("SELECT p FROM Person p WHERE p.name = :name", Person.class)
                                 .setParameter("name", name)
                                 .getResultList();
        } finally {
            entityManager.close();
        }
    }

    public static void main(String[] args) {
    }
}