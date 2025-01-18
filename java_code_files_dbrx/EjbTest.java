import java.lang.String;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.Before;
import org.junit.After;

public class EjbTest {

    @PersistenceContext private EntityManager em;

    /** Execute this before each test */
    @Before public void setup() {
        /* insert necessary data with JPQL or plain SQL here, e.g.: dbSetup.insert(em)... */
    }
    // Your tests follow...

    /** This will execute regardless of the test completion */
    @After public void cleanup() {
        em.createNamedQuery("cleanup_query").executeUpdate();
        /* Any other clean up actions can go here! */
    }

    public static void main(String[] args) {
    }
}