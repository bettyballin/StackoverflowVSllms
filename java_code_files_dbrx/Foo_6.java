import java.util.*;
import javax.persistence.*;

@Entity
@NamedQuery(
    name = "fooQuery",
    query = "SELECT f FROM Foo f WHERE f.status IN :statuses"
)
class Foo {
    @Id
    private Long id;
    private String status;

    // Constructors, getters, and setters
    public Foo() {}

    public Foo(Long id, String status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}

public class MainClass {
    public static List<Foo> getResults(EntityManager entityManager) {
        List<String> statuses = Arrays.asList("NEW", "OLD"); // Your list or set of statuses goes here.
        int paramIndex = 1; // The index corresponds to the number in the named query's parameter.
        Query q = entityManager.createNamedQuery("fooQuery").setParameter(paramIndex, statuses);
        return q.getResultList();
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myUnit");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        List<Foo> results = getResults(entityManager);

        // Do something with the results
        for (Foo foo : results) {
            System.out.println("Foo ID: " + foo.getId() + ", Status: " + foo.getStatus());
        }

        entityManager.getTransaction().commit();

        entityManager.close();
        emf.close();
    }
}