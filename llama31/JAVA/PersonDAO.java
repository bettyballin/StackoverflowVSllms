import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class PersonDAO {
    @PersistenceContext
    private EntityManager em;

    public Person findPersonByName(String name) {
        try {
            // Use the EntityManager to perform the query
            Query query = em.createQuery("SELECT p FROM Person p WHERE p.name = :name");
            query.setParameter("name", name);
            return (Person) query.getSingleResult();
        } finally {
            // Close the EntityManager (if necessary)
            // em.close();
        }
    }

    public static void main(String[] args) {
    }
}