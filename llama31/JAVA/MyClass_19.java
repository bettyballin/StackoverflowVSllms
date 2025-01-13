import java.util.TimerTask;

public class MyClass_19_19 {
    public synchronized void foo() {
        TimerTask task = new TimerTask() {
            public void run() {
                synchronized (this) { // 'this' refers to the TimerTask object
                    // ...
                }
            }
        };
        // ...
    }

    public static void main(String[] args) {
    }
}