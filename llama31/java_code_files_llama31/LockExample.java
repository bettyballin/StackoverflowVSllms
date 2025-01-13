/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    private final Lock lock = new ReentrantLock();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void method1() {
        Lock lock = this.lock;
        synchronized (lock) {
            System.out.println("Inside synchronized block");
        }
    }

    public void method2() {
        this.lock.lock();
        try {
            System.out.println("Inside lock() block");
        }
        finally {
            this.lock.unlock();
        }
    }

    public static void main(String[] stringArray) {
    }
}
