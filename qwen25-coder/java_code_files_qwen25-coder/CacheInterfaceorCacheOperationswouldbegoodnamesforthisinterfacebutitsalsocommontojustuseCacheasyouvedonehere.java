import java.lang.String;
public class CacheInterfaceorCacheOperationswouldbegoodnamesforthisinterfacebutitsalsocommontojustuseCacheasyouvedonehere {
    public interface Cache {
        void put(String key, Object value);
        Object get(String key);
        boolean remove(String key);
    }
    public static void main(String[] args) {
    }
}