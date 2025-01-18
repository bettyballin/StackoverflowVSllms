import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import javax.persistence.Entity;
import javax.persistence.Id;

public class MyProgram {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-unit"); // Your Entity Manager Factory instance

        SessionFactory sessionFactory = emf.unwrap(SessionFactory.class);
        StatelessSession session = sessionFactory.openStatelessSession();
        Transaction tx = session.beginTransaction();

        // Perform multiple insert operations
        for (int i = 0; i < 10; i++) {
            YourObject objectInstance = new YourObject();
            // Populate your attributes using the provided data...
            objectInstance.setId((long) i);
            // Set other attributes as needed
            session.insert(objectInstance);
        }

        tx.commit();

        session.close();
        emf.close();
    }

}

@Entity
class YourObject {
    @Id
    private Long id;

    // Other attributes

    public YourObject() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getters and setters for other attributes
}