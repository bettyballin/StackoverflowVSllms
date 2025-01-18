import java.net.InetSocketAddress;

public class MemCacheProvider implements CacheServiceProvider {
    private static final Logger logger = LoggerFactory.getLogger(MemCacheProvider.class);

    public void put(String key, String value) {
        //... code to put into memcached ...
    }

    public String get(String key){
        // ... code for getting from memcached ...
        return null;
    }

    public static void main(String[] args) {
    }
}

interface CacheServiceProvider {
}

class Logger {
    // Logger methods stubs
}

class LoggerFactory {
    public static Logger getLogger(Class<?> clazz) {
        return new Logger();
    }
}