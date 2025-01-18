import java.util.List;
import java.util.ArrayList;

// Annotation definition
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface PersistenceContext {
    String unitName();
}

public class PersonDAO {

    @PersistenceContext(unitName = "myPU") // Example JPA usage with a persistence unit
    private EntityManager em;

    public List<Person> findPersonByName(String name) {
        try {
            TypedQuery<Person> query = em.createNamedQuery("findByFirstname", Person.class);
            query.setParameter("firstName", name);
            return query.getResultList();
        } finally {
            // Clean up EntityManager when session is closed or committed.
        }
    }
}

class Person {
    // Minimal class definition
}

// Mock definitions for the required classes
class EntityManager {
    public <T> TypedQuery<T> createNamedQuery(String name, Class<T> resultClass) {
        return new TypedQuery<T>();
    }
}

class TypedQuery<T> {
    public void setParameter(String name, Object value) {
        // Do nothing
    }

    public List<T> getResultList() {
        return new ArrayList<T>();
    }
}