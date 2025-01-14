import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Objects;
import java.util.HashMap;
import java.util.Arrays;

public class CachedObjectLoader {
    private ObjectCache objectCache;
    private Repository repository;

    public CachedObjectLoader(ObjectCache objectCache, Repository repository) {
        this.objectCache = objectCache;
        this.repository = repository;
    }

    public List<MyObject> loadObjects(List<Long> ids) {
        // Retrieve cached objects
        Map<Long, MyObject> cachedObjects = objectCache.getAll(ids);
        List<Long> missingIds = ids.stream()
                                   .filter(id -> !cachedObjects.containsKey(id))
                                   .collect(Collectors.toList());

        // Load missing objects from database
        if (!missingIds.isEmpty()) {
            List<MyObject> loadedObjects = repository.findByIds(missingIds);
            objectCache.putAll(loadedObjects.stream().collect(Collectors.toMap(MyObject::getId, Function.identity())));
            cachedObjects.putAll(loadedObjects.stream().collect(Collectors.toMap(MyObject::getId, Function.identity())));
        }

        return ids.stream()
                  .map(cachedObjects::get)
                  .filter(Objects::nonNull)
                  .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        ObjectCache objectCache = new SimpleObjectCache();
        Repository repository = new SimpleRepository();
        CachedObjectLoader loader = new CachedObjectLoader(objectCache, repository);

        List<Long> ids = Arrays.asList(1L, 2L, 3L);
        List<MyObject> objects = loader.loadObjects(ids);

        // Print out the loaded objects
        for (MyObject obj : objects) {
            System.out.println("Loaded object with id: " + obj.getId());
        }
    }
}

class MyObject {
    private Long id;

    public MyObject(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

interface ObjectCache {
    Map<Long, MyObject> getAll(List<Long> ids);
    void putAll(Map<Long, MyObject> objects);
}

class SimpleObjectCache implements ObjectCache {
    private Map<Long, MyObject> cache = new HashMap<>();

    public Map<Long, MyObject> getAll(List<Long> ids) {
        return ids.stream()
                  .filter(cache::containsKey)
                  .collect(Collectors.toMap(Function.identity(), cache::get));
    }

    public void putAll(Map<Long, MyObject> objects) {
        cache.putAll(objects);
    }
}

interface Repository {
    List<MyObject> findByIds(List<Long> ids);
}

class SimpleRepository implements Repository {
    public List<MyObject> findByIds(List<Long> ids) {
        // For simplicity, return new MyObjects with given ids
        return ids.stream().map(MyObject::new).collect(Collectors.toList());
    }
}