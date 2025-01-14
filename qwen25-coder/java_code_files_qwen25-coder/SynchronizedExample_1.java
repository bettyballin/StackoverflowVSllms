import java.lang.String;
public class SynchronizedExample_1 {
    // Java synchronized example
    public synchronized void method() {
        // method implementation
    }

    public void anotherMethod() {
        synchronized (this) {
            // block of code
        }
    }

    public static void main(String[] args) {
    }
}