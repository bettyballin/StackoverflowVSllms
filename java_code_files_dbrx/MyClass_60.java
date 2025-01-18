import java.util.Timer;
import java.util.TimerTask;

public class MyClass {

    private final Timer timer = new Timer();

    synchronized void foo() {
        someMethod(new TimerTask() {
            synchronized public void run() {
                System.out.println("Running task");
            }
        });
    }

    void someMethod(TimerTask task) {
        timer.schedule(task, 1000);
    }

    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.foo();
    }
}