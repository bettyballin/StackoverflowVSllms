public class SimpleCacheService {
    public interface CacheServiceProvider {
        void put(String key, String value);
        String get(String key);
    }
    public static void main(String[] args) {
    }
}