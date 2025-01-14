import java.util.HashMap;
import java.util.Map;
import java.io.File;

public class CacheManager_2 {

    class CacheManager {
        private Map<String, CachedData> fileCache = new HashMap<>();
        private Map<String, CachedData> transformedCache = new HashMap<>();

        class CachedData {
            Object data;
            long lastModifiedTime; // or use version numbers

            public CachedData(Object data, long lastModifiedTime) {
                this.data = data;
                this.lastModifiedTime = lastModifiedTime;
            }
        }

        public byte[] getData(String filePath) {
            File file = new File(filePath);
            long lastModifiedTime = file.lastModified();

            if (fileCache.containsKey(filePath)) {
                CachedData cached = fileCache.get(filePath);
                if (cached.lastModifiedTime == lastModifiedTime) {
                    return (byte[]) cached.data;
                } else {
                    // Data changed, reload and update cache
                    byte[] newData = readFile(file);
                    fileCache.put(filePath, new CachedData(newData, lastModifiedTime));
                    return newData;
                }
            } else {
                byte[] newData = readFile(file);
                fileCache.put(filePath, new CachedData(newData, lastModifiedTime));
                return newData;
            }
        }

        public Object transformData(String filePath) {
            File file = new File(filePath);
            long lastModifiedTime = file.lastModified();

            String cacheKey = "transformed_" + filePath;
            if (transformedCache.containsKey(cacheKey)) {
                CachedData cached = transformedCache.get(cacheKey);
                // Check if data this entry depends on has changed
                if (cached.lastModifiedTime == lastModifiedTime) {
                    return cached.data;
                } else {
                    // Data changed, reload and update cache
                    byte[] originalData = getData(filePath); // This call checks freshness of the base file
                    Object newData = transform(originalData);
                    transformedCache.put(cacheKey, new CachedData(newData, file.lastModified()));
                    return newData;
                }
            } else {
                byte[] originalData = getData(filePath); // This call checks freshness of the base file
                Object newData = transform(originalData);
                transformedCache.put(cacheKey, new CachedData(newData, file.lastModified()));
                return newData;
            }
        }

        private byte[] readFile(File file) {
            // File reading logic here
            return new byte[0];
        }

        private Object transform(byte[] data) {
            // Data transformation logic here
            return new Object();
        }
    }

    public static void main(String[] args) {
        // Entry point for execution
    }
}