import java.util.TimerTask;
import java.util.Timer;

public class MyClass_20_20 {
    public synchronized void foo() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                synchronized (MyClass_20.this) { // 'MyClass_20.this' refers to the outer class instance
                    // ...
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0); // Schedule the task for immediate execution
    }

    public static void main(String[] args) {
        MyClass_20 obj = new MyClass_20();
        obj.foo();
    }
}