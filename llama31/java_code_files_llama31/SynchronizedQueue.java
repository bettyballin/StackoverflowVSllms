/*
 * Decompiled with CFR 0.152.
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedQueue<T> {
    private final Queue<T> queue = new LinkedList<T>();
    private final Lock lock = new ReentrantLock();
    private final Condition notEmpty = this.lock.newCondition();

    public void add(T t) {
        this.lock.lock();
        try {
            this.queue.add(t);
            this.notEmpty.signal();
        }
        finally {
            this.lock.unlock();
        }
    }

    public T remove() throws InterruptedException {
        this.lock.lock();
        try {
            while (this.queue.isEmpty()) {
                this.notEmpty.await();
            }
            T t = this.queue.poll();
            return t;
        }
        finally {
            this.lock.unlock();
        }
    }

    public static void main(String[] stringArray) {
    }
}
