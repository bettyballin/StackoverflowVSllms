import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Entity
class User {
    @Id
    private Long id;
    private String name;

    // Hibernate takes a snapshot of this object when it's loaded

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id= id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

}

public class Main {
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(User.class)
            .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try {
            // Later in the session
            session.beginTransaction();
            User user = session.get(User.class, 1L);  // Load user with id=1
            user.setName("New Name");                 // Modify the name
            session.getTransaction().commit();          // Triggers flush; Hibernate detects the change and updates the database
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}