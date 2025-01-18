import java.lang.String;

public class SynchronizedBlockExample_1 {
    private final Object syncObject = new Object();

    void bar() {
        synchronized(syncObject) {
            /* your critical section code */
        }
    }

    public static void main(String[] args) {
    }
}