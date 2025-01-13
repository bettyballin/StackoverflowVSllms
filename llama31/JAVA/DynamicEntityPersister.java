import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Assuming EntityPersister, SessionFactoryImplementor, SingleTableEntityPersister, 
// and SessionImplementor are existing classes/interfaces in your project
public interface EntityPersister {
    void load(Serializable id, Object optionalObject, SessionImplementor session);
}

public interface SessionFactoryImplementor {
    // existing methods
}

public class SingleTableEntityPersister implements EntityPersister {
    private final Class<?> entityClass;
    private final SessionFactoryImplementor sessionFactory;

    public SingleTableEntityPersister(Class<?> entityClass, SessionFactoryImplementor sessionFactory) {
        this.entityClass = entityClass;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void load(Serializable id, Object optionalObject, SessionImplementor session) {
        // existing implementation
    }
}

public interface SessionImplementor {
    // existing methods
}

public class DynamicEntityPersister implements EntityPersister {
    private final SessionFactoryImplementor sessionFactory;
    private final Map<String, EntityPersister> entityPersisterMap;

    public DynamicEntityPersister(SessionFactoryImplementor sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.entityPersisterMap = new ConcurrentHashMap<>();
    }

    public void registerEntity(Class<?> entityClass) {
        EntityPersister persister = new SingleTableEntityPersister(entityClass, sessionFactory);
        entityPersisterMap.put(entityClass.getName(), persister);
    }

    public void unregisterEntity(Class<?> entityClass) {
        entityPersisterMap.remove(entityClass.getName());
    }

    @Override
    public void load(Serializable id, Object optionalObject, SessionImplementor session) {
        // delegate to the actual persister
        EntityPersister persister = entityPersisterMap.get(optionalObject.getClass().getName());
        if (persister != null) {
            persister.load(id, optionalObject, session);
        }
    }

    public static void main(String[] args) {
    }
}