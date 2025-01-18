import java.util.LinkedHashMap;
import java.util.Map;

public class LastNUrlsCache {
    private final LinkedHashMap<String, String> lastNUrlsMap;
    private final int maxSize;

    public LastNUrlsCache(int size) {
        this.maxSize = size;
        this.lastNUrlsMap = new LinkedHashMap<String, String>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest){
                return size() > maxSize;
            }
        };
    }

    public void addUrl(String url) {
        this.lastNUrlsMap.put(url, ""); // use empty value as placeholder here
    }

    public static void main(String[] args) {
    }
}