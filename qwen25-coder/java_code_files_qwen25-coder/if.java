import java.util.Map;
import java.util.HashMap;

public class MyClass implements MyInterface {

    private Map<String, Bitmap> fullMap = new HashMap<>();
    private Object currentBitmap;

    @Override
    public synchronized Bitmap getFullBitmap(Filter f, ProgressCallback<String> pc) {
        // No need to synchronize the whole class if this is the only method that needs it
        Bitmap bitmap = fullMap.get(f.id);
        if (bitmap == null) {
            f.setProgressCallback(pc);
            bitmap = f.e.evaluate(currentBitmap);
            fullMap.put(f.id, bitmap);
        }
        return bitmap;
    }

    public static void main(String[] args) {
    }

}

interface MyInterface {
    Bitmap getFullBitmap(Filter f, ProgressCallback<String> pc);
}

class Bitmap {}

class Filter {
    public String id;
    public E e;
    public void setProgressCallback(ProgressCallback<String> pc) {}
}

class E {
    public Bitmap evaluate(Object currentBitmap) {
        return new Bitmap();
    }
}

class ProgressCallback<T> {}