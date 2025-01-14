import javax.persistence.*;
import java.util.*;

public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    private static EntityManager entityManager = emf.createEntityManager();

    @Entity
    @NamedQuery(
        name = "fooQuery",
        query = "select f from Foo f where f.status in (:statusValues)"
    )
    public static class Foo {
        @Id
        private Long id;
        private String status;

        // Constructors
        public Foo() {}
        public Foo(Long id, String status){
            this.id = id;
            this.status = status;
        }
        // Getters and setters
        public Long getId() {
            return id;
        }
        public void setId(Long id){
            this.id = id;
        }
        public String getStatus() {
            return status;
        }
        public void setStatus(String status){
            this.status = status;
        }
    }

    public static void main(String[] args) {
        List<Foo> foos = fetchFoos();
        for (Foo foo : foos) {
            System.out.println("Foo ID: " + foo.getId() + ", Status: " + foo.getStatus());
        }
    }

    public static List<Foo> fetchFoos() {
        List<String> statusValues = Arrays.asList("NEW", "OLD");
        TypedQuery<Foo> q = entityManager.createNamedQuery("fooQuery", Foo.class);
        q.setParameter("statusValues", statusValues); // Pass the list directly
        return q.getResultList();
    }
}