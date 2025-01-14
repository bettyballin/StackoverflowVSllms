import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.configuration.CacheConfiguration;

public class IgniteExample {
    public static void main(String[] args) throws Exception {
        // Start an Ignite node.
        try (Ignite ignite = Ignition.start("examples/config/example-ignite.xml")) {

            // Create or get an existing cache named "myCache".
            IgniteCache<String, MyObject> myCache = ignite.getOrCreateCache("myCache", new CacheConfiguration<String, MyObject>()
                    .setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL)
                    .setBackups(1));

            for (int i = 0; i < 20000; i++) {
                // Putting data into cache.
                myCache.put("key" + i, new MyObject(i));
            }

            // Reading data from the cache.
            for (int i = 0; i < 20000; i += 1000) {
                System.out.println(myCache.get("key" + i));
            }
        }
    }
}

class MyObject implements java.io.Serializable {
    private int id;

    public MyObject(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "id=" + id +
                '}';
    }
}