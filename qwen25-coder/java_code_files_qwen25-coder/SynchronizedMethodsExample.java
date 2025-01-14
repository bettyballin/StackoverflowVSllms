import java.lang.String;
public class SynchronizedMethodsExample {

    public synchronized void method1() {
        // Synchronize entire method on 'this'
        System.out.println("Method 1 executed by " + Thread.currentThread().getName());
    }

    public void method2() {
        // Synchronize specific block on 'this'
        synchronized (this) {
            System.out.println("Method 2 executed by " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final SynchronizedMethodsExample example = new SynchronizedMethodsExample();

        Thread t1 = new Thread(() -> example.method1(), "Thread-1");
        Thread t2 = new Thread(() -> example.method2(), "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}