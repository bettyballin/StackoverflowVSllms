import java.util.List;

@Service
public class MyService_8 {

    @PersistenceContext(unitName = "pu1")
    private EntityManager entityManagerPrimary;

    @PersistenceContext(unitName = "pu2")
    private EntityManager entityManagerSecondary;

    public void readOnlyOperation(boolean useSecondaryDataSource) {
        EntityManager em = useSecondaryDataSource ? entityManagerSecondary : entityManagerPrimary;

        // Disable auto flush for secondary data source
        if (useSecondaryDataSource) {
            em.setFlushMode(FlushMode.MANUAL); // or FlushMode.COMMIT
        }

        try {
            // Execute your read-only query here
            List<YourEntity> entities = em.createQuery("SELECT e FROM YourEntity e", YourEntity.class).getResultList();
        } finally {
            // Re-enable auto flush for primary data source if necessary
            if (!useSecondaryDataSource) {
                em.setFlushMode(FlushMode.AUTO);
            }
        }
    }

    public static void main(String[] args) {
    }
}

class YourEntity {
}

class EntityManager {
    public void setFlushMode(FlushMode flushMode) {
        // Implementation here
    }

    public <T> Query<T> createQuery(String query, Class<T> resultClass) {
        return new Query<T>();
    }
}

enum FlushMode {
    MANUAL,
    COMMIT,
    AUTO
}

class Query<T> {
    public List<T> getResultList() {
        return null;
    }
}

@interface Service {
}

@interface PersistenceContext {
    String unitName();
}