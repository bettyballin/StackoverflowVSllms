import java.util.*;
import java.util.concurrent.*;
import java.lang.reflect.*;

public class CustomORM<T> {
    private ConcurrentHashMap<Long, T> dataMap = new ConcurrentHashMap<>();
    private Class<T> entityClass; // e.g., MyEntity.class

    public CustomORM(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    // Store a single object in the ORM layer
    public void storeObject(T obj) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Long id = null;
        // Extract id from the object using reflection
        Field idField = entityClass.getDeclaredField("id");
        idField.setAccessible(true);
        id = (Long) idField.get(obj);
        dataMap.put(id, obj);
    }

    // Store a collection of objects in the ORM layer
    public void storeObjects(Collection<T> objs) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        for (T obj : objs) {
            this.storeObject(obj);
        }
    }

    // Retrieve single object from ORM layer based on key
    public T getObjectById(Long id) {
        return dataMap.get(id);
    }
}