import java.lang.String;

public class SyncExample_1 {
    public synchronized void methodSync() {
        System.out.println("Method sync");
    }

    public void blockSync() {
        synchronized (this) {
            System.out.println("Block sync");
        }
    }

    public static void main(String[] args) {
        SyncExample instance = new SyncExample();

        Thread t1 = new Thread(() -> instance.methodSync());
        Thread t2 = new Thread(() -> instance.blockSync());

        t1.start();
        t2.start();
    }
}