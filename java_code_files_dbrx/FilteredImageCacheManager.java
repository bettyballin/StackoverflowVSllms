import java.util.Map;
import java.util.HashMap;

public class Bitmap {
}

public class E {
    public Bitmap evaluate(Bitmap bitmap) {
        return null;
    }
}

public interface ProgressCallback<T> {
}

public class Filter {
    public Object id;
    public E e;
    public void setProgressCallback(ProgressCallback<String> pc) {
    }
}

public interface ImageCacheManager {
    public Bitmap getFullBitmap(Filter f, ProgressCallback<String> pc);
}

public class FilteredImageCacheManager implements ImageCacheManager {

    private Map<Object, Bitmap> fullMap = new HashMap<>();
    private Bitmap currentBitmap;

    @Override
    public Bitmap getFullBitmap(Filter f, ProgressCallback<String> pc) {
        // Use synchronization block on fullMap to prevent concurrent modifications
        synchronized (fullMap) {
            Bitmap bitmap = fullMap.get(f.id);
            if (bitmap == null) {
                f.setProgressCallback(pc);
                bitmap = f.e.evaluate(currentBitmap);
                // Add the final keyword to avoid mutation after object creation
                fullMap.put(f.id, bitmap);
            }
            return bitmap;
        }
    }

    public static void main(String[] args) {
    }
}