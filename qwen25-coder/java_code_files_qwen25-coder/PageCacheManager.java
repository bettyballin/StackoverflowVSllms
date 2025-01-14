import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PageCacheManager {

    private static final Map<Integer, Object> locks = new ConcurrentHashMap<>();
    private static final Cache cache = new Cache();

    public Page getPage(Integer id) {
        Page p = cache.get(id);
        if (p == null) {
            synchronized (locks.computeIfAbsent(id, k -> new Object())) {
                // Double check to prevent multiple retrievals in case of race conditions
                p = cache.get(id);
                if (p == null) {
                    p = getFromDataBase(id);
                    cache.store(p);
                }
            }
        }
        return p;
    }

    private Page getFromDataBase(Integer id) {
        // Simulate database access
        return new Page(id);
    }

    public static void main(String[] args) {
        // Example usage
        PageCacheManager manager = new PageCacheManager();
        Page page = manager.getPage(1);
        System.out.println("Got page with id: " + page.getId());
    }
}

class Page {
    private final Integer id;

    public Page(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}

class Cache {
    private final Map<Integer, Page> pages = new ConcurrentHashMap<>();

    public Page get(Integer id) {
        return pages.get(id);
    }

    public void store(Page p) {
        pages.put(p.getId(), p);
    }
}