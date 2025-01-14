import net.spy.memcached.MemcachedClient;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

interface Cache {
    void put(String key, Object value);
    Object get(String key);
    boolean remove(String key) throws InterruptedException, ExecutionException;
}

public class MemCacheImpl implements Cache {
    private final MemcachedClient memcachedClient;

    public MemCacheImpl(MemcachedClient memcachedClient) {
        this.memcachedClient = memcachedClient;
    }

    @Override
    public void put(String key, Object value) {
        memcachedClient.set(key, 0, value);
    }

    @Override
    public Object get(String key) {
        return memcachedClient.get(key);
    }

    @Override
    public boolean remove(String key) throws InterruptedException, ExecutionException {
        return memcachedClient.delete(key).get();
    }

    public static void main(String[] args) {
        // Optional: Add code here to test the implementation.
    }
}