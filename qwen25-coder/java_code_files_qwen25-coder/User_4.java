import java.lang.String;
import java.lang.Integer;
import javax.persistence.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table(name = "users")
public class User_4 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "username", unique = true, nullable = false, length = 45)
    private String username;

    // Getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            User_4 user = new User_4();
            user.setUsername("john_doe");
            session.save(user);

            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction != null) transaction.rollback();
            throw e; // or some other error handling
        } finally {
            session.close();
        }
    }
}