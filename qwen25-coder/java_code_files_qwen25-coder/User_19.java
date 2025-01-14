import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.Transaction;

// Example of using an ORM (Hibernate) in Java instead of raw SQL
@Entity
public class User_19 {
    @Id
    private Long id;
    private String name;

    public User_19() {
        // default constructor
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class MainClass {
    public static void main(String[] args) {
        // Assuming configuration file is present
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        User_19 user = new User_19();
        user.setName("John Doe");
        session.save(user);

        tx.commit();
        session.close();
    }
}