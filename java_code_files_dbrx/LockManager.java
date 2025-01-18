import java.lang.String;
public class LockManager {
    private final Object lockObject = new Object();

    {
        synchronized(lockObject){ // use a lock object to protect shared resource
            // critical section - perform your operation
        }
    }

    public static void main(String[] args) {
    }
}