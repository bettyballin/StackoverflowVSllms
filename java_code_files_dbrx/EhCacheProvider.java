public interface CacheServiceProvider {
    void put(String key, String value);
    String get(String key);
}

public class EhCacheProvider implements CacheServiceProvider {
    private static final Logger logger = LoggerFactory.getLogger(EhCacheProvider.class);

    public void put(String key, String value) {
        //... code for putting in ehcahce ...
    }

    public String get(String key) {
        //... code for getting from ehcahce ...
        return null;
    }

    public static void main(String[] args) {
    }
}

class Logger {
    // Minimal Logger implementation
}

class LoggerFactory {
    public static Logger getLogger(Class<?> clazz) {
        return new Logger();
    }
}