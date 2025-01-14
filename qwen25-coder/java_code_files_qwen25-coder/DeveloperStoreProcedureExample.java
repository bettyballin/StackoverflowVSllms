import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.persistence.Entity;
import javax.persistence.Id;

public class DeveloperStoreProcedureExample {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            
            // Calling stored procedure
            List<Developer> developers = session
                .createStoredProcedureQuery("CALL GetDevelopers()", Developer.class)
                .getResultList();
            
            // Process the result
            
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}

@Entity
class Developer {

    @Id
    private int id;
    private String name;

    // Getters and setters...
}