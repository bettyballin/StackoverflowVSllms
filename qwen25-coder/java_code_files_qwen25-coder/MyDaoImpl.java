import java.util.List;
import java.util.ArrayList;

@Repository
public class MyDaoImpl implements MyDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void saveEntity(MyEntity entity) {
        entityManager.persist(entity);
    }

    @Override
    public List<MyEntity> findAllEntities() {
        return entityManager.createQuery("SELECT e FROM MyEntity e", MyEntity.class).getResultList();
    }

    public static void main(String[] args) {
    }
}

// Define annotations
@interface Repository {
}

@interface PersistenceContext {
}

@interface Transactional {
}

// Define MyDao interface
interface MyDao {
    void saveEntity(MyEntity entity);
    List<MyEntity> findAllEntities();
}

// Define MyEntity class
class MyEntity {
    // Fields and methods as necessary
}

// Define EntityManager class
class EntityManager {
    public void persist(Object entity) {
        // Implementation as necessary
    }

    public <T> Query<T> createQuery(String qlString, Class<T> resultClass) {
        return new Query<T>();
    }
}

// Define Query class
class Query<T> {
    public List<T> getResultList() {
        return new ArrayList<T>();
    }
}