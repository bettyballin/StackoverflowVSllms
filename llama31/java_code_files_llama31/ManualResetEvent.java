/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Semaphore;

public class ManualResetEvent {
    private final Semaphore semaphore;

    public ManualResetEvent(boolean bl) {
        this.semaphore = new Semaphore(bl ? 1 : 0);
    }

    public void set() {
        this.semaphore.release();
    }

    public void reset() {
        this.semaphore.drainPermits();
    }

    public void waitOne() throws InterruptedException {
        this.semaphore.acquire();
    }

    public static void main(String[] stringArray) {
    }
}
