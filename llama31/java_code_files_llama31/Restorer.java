/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.locks.ReentrantLock;

public class Restorer<T> {
    private final ReentrantLock lock = new ReentrantLock();

    public T restore(String string) throws Exception {
        this.lock.lock();
        try {
            T t = null;
            return t;
        }
        finally {
            this.lock.unlock();
        }
    }

    public static void main(String[] stringArray) {
    }
}
