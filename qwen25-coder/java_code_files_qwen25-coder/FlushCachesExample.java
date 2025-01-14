import java.util.Collection;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.cache.Cache;

public class FlushCachesExample {

    public static void main(String[] args) {
        // Assuming you have an instance of SqlSessionFactory
        SqlSessionFactory sessionFactory = getSessionFactory(); // Implement this method to obtain your SqlSessionFactory

        // Flush all caches
        Collection<Cache> caches = sessionFactory.getConfiguration().getCaches();
        for (Cache cache : caches) {
            cache.clear();
        }

        // Alternatively, specific cache flushing based on a mapper name (namespace)
        String namespace = "yourNamespace";
        Cache cache = sessionFactory.getConfiguration().getCache(namespace);
        if (cache != null) {
            cache.clear();
        }
    }

    private static SqlSessionFactory getSessionFactory() {
        // Implement this method to return your SqlSessionFactory instance
        return null; // Placeholder return statement
    }
}