import java.lang.ref.WeakReference;

public class GarbageCollectionChecker {

    public static void main(String[] args) {
        Object yourObject = new Object();
        WeakReference<Object> ref = new WeakReference<>(yourObject);

        // Somewhere else, where you expect the object to be cleared after use or null at that moment
        yourObject = null; // Make the object eligible for garbage collection

        System.gc(); // Optional call of GC (garbage collector) if it's not called yet for this variable

        if(ref.get() == null) {
            System.out.println("Reference is clear and ready for JVM garbage collection");
        } else {
           System.out.println("Reference still exists!");
        }
    }
}