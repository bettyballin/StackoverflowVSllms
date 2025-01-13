/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AutoLock_1 {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void doSomething() {
        this.lock.readLock().lock();
        this.lock.readLock().unlock();
    }

    public static void main(String[] stringArray) {
    }
}
