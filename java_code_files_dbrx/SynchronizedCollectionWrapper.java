import java.lang.String;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

public class SynchronizedCollectionWrapper {
    Collection myUnsynchronizedCollection = new ArrayList();
    Collection c = Collections.synchronizedCollection(myUnsynchronizedCollection);
    // Now your 'c' is synchronized and can be shared between threads safely.
    public static void main(String[] args) {
    }
}