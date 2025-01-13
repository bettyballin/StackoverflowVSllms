import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

// Define an entity using JPA annotations
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Main_676 {
    public static void main(String[] args) {
        // Create a Hibernate session factory
        Configuration cfg = new Configuration();
        cfg.configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        SessionFactory sessionFactory = cfg.buildSessionFactory(builder.build());

        // Create a JPA entity manager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
        EntityManager em = emf.createEntityManager();

        // Use the entity manager to persist and retrieve entities
        User user = new User();
        user.setName("John Doe");
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        User retrievedUser = em.find(User.class, user.getId());
        System.out.println(retrievedUser.getName());
        em.close();
        emf.close();
    }
}