import javax.persistence.Entity;
import javax.persistence.PostPersist;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Entity
public class SearchRule {
    // Assuming you're using container-managed persistence, inject the EntityManager.
    // For application-managed persistence, you'd need to create an EntityManagerFactory and then an EntityManager instance from it.
    @PersistenceContext
    private EntityManager entityManager;

    // ...

    @PostPersist
    public void afterPersist() {
        // Create and persist the FieldRule entities
        FieldRule fieldRule = new FieldRule();
        // ...
        entityManager.persist(fieldRule);
    }

    public static void main(String[] args) {
        // This main method won't actually do anything with the class since it's designed for use within a persistence context.
    }
}

// Assuming FieldRule is another entity, define it in a minimal form to avoid compilation errors.
@Entity
class FieldRule {
    // Add necessary fields, getters, setters, etc.
}