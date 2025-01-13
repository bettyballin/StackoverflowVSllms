import org.hibernate.SessionFactory;
import org.hibernate.persister.entity.DynamicEntityPersister;

public class UserManager {
    private final SessionFactory sessionFactory;

    public UserManager(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void registerType(Class<?> entityClass) {
        DynamicEntityPersister persister = (DynamicEntityPersister) sessionFactory.getEntityPersister(entityClass.getName());
        persister.registerEntity(entityClass);
    }

    public void unregisterType(Class<?> entityClass) {
        DynamicEntityPersister persister = (DynamicEntityPersister) sessionFactory.getEntityPersister(entityClass.getName());
        persister.unregisterEntity(entityClass);
    }

    public static void main(String[] args) {
    }
}