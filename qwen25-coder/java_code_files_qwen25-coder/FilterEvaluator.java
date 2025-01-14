import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public class FilterEvaluator implements BitmapProvider {

    private Map<String, Bitmap> fullMap = new HashMap<>();
    private Bitmap currentBitmap = new Bitmap();

    @Override
    public Bitmap getFullBitmap(Filter f, ProgressCallback<String> pc) {
        Bitmap bitmap = fullMap.get(f.id);
        if (bitmap == null) {
            synchronized (fullMap) { // Synchronize only on operations involving fullMap
                bitmap = fullMap.get(f.id); // Double-check inside the synchronized block
                if (bitmap == null) {
                    f.setProgressCallback(pc);
                    bitmap = f.e.evaluate(currentBitmap);
                    fullMap.put(f.id, bitmap);
                }
            }
        }
        return bitmap;
    }

    public static void main(String[] args) {
    }
}

interface BitmapProvider {
    Bitmap getFullBitmap(Filter f, ProgressCallback<String> pc);
}

class Filter {
    public String id;
    public Evaluator e;
    public void setProgressCallback(ProgressCallback<String> pc) {
    }
}

class Evaluator {
    public Bitmap evaluate(Bitmap bitmap) {
        return bitmap; // stub implementation
    }
}

interface ProgressCallback<T> {
    void onProgress(T progress);
}

class Bitmap {
    // placeholder
}