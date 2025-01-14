import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main_96 {
    public static void main(String[] args) {
        // Create configuration instance
        Configuration configuration = new Configuration();
        configuration.configure(); // will use hibernate.cfg.xml

        // build session factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // open session
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            // start a transaction
            transaction = session.beginTransaction();

            // example of saving an entity
            Employee employee = new Employee("John Doe", "Developer");
            session.save(employee);

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private String position;

    public Employee() {}

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    // Getters and setters (optional)
}