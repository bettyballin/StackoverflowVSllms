import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// Define the A entity
@Entity
@Table(name = "A")
class A {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "a", orphanRemoval = true)
    private Set<B> bs;

    public A() {
        this.bs = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<B> getBs() {
        return bs;
    }

    public void setBs(Set<B> bs) {
        this.bs = bs;
    }
}

// Define the B entity
@Entity
@Table(name = "B")
class B {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "a_id")
    private A a;

    @ManyToMany
    @JoinTable(
            name = "B_A",
            joinColumns = @JoinColumn(name = "b_id"),
            inverseJoinColumns = @JoinColumn(name = "a_id")
    )
    private Set<A> as;

    public B() {
        this.as = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public Set<A> getAs() {
        return as;
    }

    public void setAs(Set<A> as) {
        this.as = as;
    }
}

public class Main_353 {
    public static void main(String[] args) {
        // Create a Hibernate session factory
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        // Obtain a Hibernate session instance
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        // Create an instance of A and save it to the database
        A a = new A();
        session.save(a);

        // Create an instance of B and save it to the database
        B b = new B();
        b.setA(a);
        a.getBs().add(b);
        session.save(b);

        // Commit the transaction
        session.getTransaction().commit();

        // Start a new transaction
        session.beginTransaction();

        // Retrieve the A instance from the database
        a = session.get(A.class, 1L);

        // Retrieve the B instance from the A instance
        b = a.getBs().iterator().next();
        Long bId = b.getId();

        // Remove the B instance from the A instance
        a.getBs().remove(b);
        session.update(a);

        // Commit the transaction
        session.getTransaction().commit();

        // Invalidate the cache for B
        sessionFactory.getCurrentSession().evict(B.class, bId);

        // Start a new transaction
        session.beginTransaction();

        // Retrieve the B instance from the database
        B b2 = session.get(B.class, bId);

        // Retrieve the A instances associated with the B instance
        Collection<A> as = b2.getAs();

        // Commit the transaction
        session.getTransaction().commit();

        // Close the Hibernate session factory
        sessionFactory.close();
    }
}