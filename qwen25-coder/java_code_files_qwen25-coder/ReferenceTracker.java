import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ReferenceTracker {
    public static void main(String[] args) throws InterruptedException {
        // Create an object you want to track
        Object obj = new Object();

        // Wrap it in a WeakReference
        WeakReference<Object> weakRef = new WeakReference<>(obj);

        // Simulate strong references by adding the object to a list
        List<Object> strongRefs = new ArrayList<>();
        strongRefs.add(obj);

        System.out.println("Object has strong reference.");
        printReferent(weakRef);

        // Remove the strong reference
        strongRefs.remove(obj);
        obj = null;

        // Allow garbage collection
        System.gc();

        // Wait a moment for GC to occur
        Thread.sleep(500);

        System.out.println("After removing strong reference and calling gc().");
        printReferent(weakRef);
    }

    private static void printReferent(WeakReference<Object> ref) {
        Object referent = ref.get();
        if (referent != null) {
            System.out.println("Reference object is still alive.");
        } else {
            System.out.println("Reference object has been collected.");
        }
    }
}