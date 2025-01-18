import java.util.Map;
import java.util.HashMap;

public class PageCacheManager {
    Map<Integer, Page> cache = new HashMap<>();

    static final Integer lockForInt(int value) {
        return new Integer(value);
    }

    public Page getPage(Integer id) {
        Page p = cache.get(id);
        if (p == null) {
            synchronized (lockForInt(id)) {
                //..retrieve and store logic here
            }
        }
        return p;
    }

    public static void main(String[] args) {
    }
}

class Page {
}