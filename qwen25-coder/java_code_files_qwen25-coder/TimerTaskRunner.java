import java.util.TimerTask;

public class TimerTaskRunner {
    public synchronized void foo() {
        someMethod(new TimerTask() {
            public void run() {
                synchronized(this) {
                    //stuff
                }
            }
        });
    }

    public void someMethod(TimerTask task) {
        // placeholder
    }

    public static void main(String[] args) {
    }
}