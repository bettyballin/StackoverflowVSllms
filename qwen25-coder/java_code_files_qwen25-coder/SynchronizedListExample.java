import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SynchronizedListExample {
    private final List<Integer> a = Collections.synchronizedList(new ArrayList<>());

    void exampleMethod() {
        synchronized(a) { // Use the lock associated with the collection itself
            // modify a
        }
    }

    public static void main(String[] args) {
    }
}