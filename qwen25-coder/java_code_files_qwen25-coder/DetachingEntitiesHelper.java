import java.util.List;
import javax.persistence.EntityManager;

public class DetachingEntitiesHelper {
    // Assuming 'entityManager' is your EntityManager instance and 'EntityClass' is the type of entity you are querying

    private EntityManager entityManager;

    public DetachingEntitiesHelper(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void detachEntities() {
        List<EntityClass> results = entityManager.createQuery("SELECT e FROM EntityClass e", EntityClass.class).getResultList();
        for (EntityClass entity : results) {
            entityManager.detach(entity);
        }
    }

    public static void main(String[] args) {
        // Example usage (assuming you have an EntityManager instance)
        // EntityManager em = ...;
        // DetachingEntitiesHelper helper = new DetachingEntitiesHelper(em);
        // helper.detachEntities();
    }
}

class EntityClass {
    // Define your entity fields and methods here
}