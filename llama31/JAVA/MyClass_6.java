import java.lang.String;

public class MyClass_6_6 {
    private Object myObject = new Object();

    public synchronized void myMethod() {
        // lock is acquired on the entire object
    }

    public void myMethod2() {
        synchronized (this) {
            // lock is acquired on the entire object
        }
    }

    public void myMethod3() {
        synchronized (myObject) {
            // lock is acquired only on myObject
        }
    }

    public static void main(String[] args) {
    }
}