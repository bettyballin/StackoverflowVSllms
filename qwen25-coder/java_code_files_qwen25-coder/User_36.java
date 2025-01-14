// Definitions for annotations and interfaces to make the code compile
public @interface Entity { }

public @interface Id { }

public @interface Stateless { }

public @interface PersistenceContext { }

public enum ParameterMode {
    IN, OUT, INOUT;
}

public class EntityManager {
    public StoredProcedureQuery createStoredProcedureQuery(String procedureName) {
        return new StoredProcedureQuery();
    }
}

public class StoredProcedureQuery {
    public void registerStoredProcedureParameter(int position, Class<?> type, ParameterMode mode) {
        // Implementation goes here
    }

    public void setParameter(int position, Object value) {
        // Implementation goes here
    }

    public void execute() {
        // Implementation goes here
    }
}

public interface JpaRepository<T, ID> { }

// Using JPA for CRUD operations
@Entity
public class User_36 {
    @Id
    private Long id;
    private String name;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id= id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// Repository interface using JPA
public interface UserRepository extends JpaRepository<User_36, Long> {}

// Calling a stored procedure
@Stateless
public class User_36Service {
    @PersistenceContext
    private EntityManager em;

    public void callStoredProc(Long userId) {
        StoredProcedureQuery query = em.createStoredProcedureQuery("update_user_status");
        query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
        query.setParameter(1, userId);
        query.execute();
    }

    // Setter for EntityManager to simulate @PersistenceContext injection
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public static void main(String[] args) {
        User_36Service service = new User_36Service();
        service.setEntityManager(new EntityManager()); // Manually setting EntityManager
        service.callStoredProc(1L);
    }
}