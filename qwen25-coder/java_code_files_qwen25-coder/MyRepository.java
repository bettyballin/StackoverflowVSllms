import java.util.List;
import java.util.ArrayList;

public class MyRepository {
    private EntityManager em;

    public MyRepository(EntityManager em) {
        this.em = em;
    }

    public void batchInsert(List<MyEntity> entities) {
        Session session = em.unwrap(Session.class);
        int batchSize = 50; // Example batch size

        for (int i = 0; i < entities.size(); i++) {
            session.save(entities.get(i));
            if (i % batchSize == 0 && i > 0) { // Flush and clear session every <batchSize> inserts
                session.flush();
                session.clear();
            }
        }
    }

    public static void main(String[] args) {
        MyEntity entity = new MyEntity();
        List<MyEntity> entities = new ArrayList<>();
        entities.add(entity);

        EntityManager em = new EntityManager();
        MyRepository repo = new MyRepository(em);
        repo.batchInsert(entities);
    }
}

class MyEntity {
    // Define properties and methods as needed
}

class EntityManager {
    public <T> T unwrap(Class<T> cls) {
        return cls.cast(new Session());
    }
}

class Session {
    public void save(Object entity) {
        // Implement save logic
    }

    public void flush() {
        // Implement flush logic
    }

    public void clear() {
        // Implement clear logic
    }
}