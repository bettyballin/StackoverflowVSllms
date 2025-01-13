import javax.persistence.Entity;
import javax.persistence.Id;

// User.java
@Entity
class User {
    @Id
    private Long id;
    private String name;

    public User() {}

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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

// EntityManager.java (Simplified for demonstration)
interface EntityManager {
    <T> T find(Class<T> entityClass, Object primaryKey);
    void persist(Object entity);
}

// EntityManagerImpl.java (Simplified for demonstration)
class EntityManagerImpl implements EntityManager {
    @Override
    public <T> T find(Class<T> entityClass, Object primaryKey) {
        // Simplified example, real implementation would involve database access
        if (entityClass == User.class && primaryKey.equals(1L)) {
            return entityClass.cast(new User(1L, "John Doe"));
        }
        return null;
    }

    @Override
    public void persist(Object entity) {
        // Simplified, in real scenarios this would save to the database
        System.out.println("Saving entity: " + entity);
    }
}

// UserRepository.java
interface UserRepository {
    User getUserById(Long id);
    void saveUser(User user);
}

// UserRepositoryImpl.java
class UserRepositoryImpl implements UserRepository {
    private final EntityManager entityManager;

    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    public static void main(String[] args) {
        EntityManager entityManager = new EntityManagerImpl();
        UserRepository userRepository = new UserRepositoryImpl(entityManager);

        User user = userRepository.getUserById(1L);
        System.out.println("Found User: " + user.getName());

        User newUser = new User(2L, "Jane Doe");
        userRepository.saveUser(newUser);
    }
}