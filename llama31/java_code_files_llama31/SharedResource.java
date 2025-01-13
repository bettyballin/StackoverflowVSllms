/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    private final ReentrantLock lock = new ReentrantLock();

    public void accessResource() {
        this.lock.lock();
        this.lock.unlock();
    }

    public static void main(String[] stringArray) {
    }
}
