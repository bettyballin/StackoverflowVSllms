import java.lang.String;

class MyClass {
    private int instanceVar;

    public synchronized void setInstanceVar() {
        this.instanceVar = 10; // or any other value
    }

    public synchronized int getInstanceVar() {
        return instanceVar;
    }
}

public class SynchronizedAccessor {
    MyClass sharedInstance = new MyClass();

    public void test() throws InterruptedException {
        // Thread 1
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                sharedInstance.setInstanceVar();
            }
        });

        // Thread 2
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                sharedInstance.getInstanceVar();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedAccessor accessor = new SynchronizedAccessor();
        accessor.test();
    }
}