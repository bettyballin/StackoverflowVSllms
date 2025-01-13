/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizationExamples {
    Semaphore semaphore = new Semaphore(5);
    ReentrantLock mutex = new ReentrantLock();

    public void accessResource() throws InterruptedException {
        this.semaphore.acquire();
        this.semaphore.release();
    }

    public void accessCriticalSection() {
        this.mutex.lock();
        this.mutex.unlock();
    }

    public synchronized void guardedMethod() {
    }

    public static void main(String[] stringArray) throws InterruptedException {
        SynchronizationExamples synchronizationExamples = new SynchronizationExamples();
        synchronizationExamples.accessResource();
        synchronizationExamples.accessCriticalSection();
        synchronizationExamples.guardedMethod();
    }
}
