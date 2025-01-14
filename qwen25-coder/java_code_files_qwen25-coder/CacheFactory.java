import java.lang.String;
import java.util.ServiceLoader;

public class CacheFactory {
    public static Cache getCacheInstance(String implementationClassName) throws Exception {
        for (Cache cacheService : ServiceLoader.load(Cache.class)) {
            if (cacheService.getClass().getName().equals(implementationClassName)) {
                return cacheService;
            }
        }
        throw new ClassNotFoundException("No cache implementation found for " + implementationClassName);
    }

    public static void main(String[] args) {
    }
}

interface Cache {
    // Empty interface as a placeholder for the Cache service
}