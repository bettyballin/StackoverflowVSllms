import java.util.concurrent.Semaphore;

public class SynchronizationExamples {
    // Semaphore example (5 available resources)
    Semaphore semaphore = new Semaphore(5);
    public void accessResource() throws InterruptedException {
        semaphore.acquire();
        // Use the resource
        semaphore.release();
    }

    // Mutex example is replaced with ReentrantLock (Java does not have Mutex built-in)
    java.util.concurrent.locks.ReentrantLock mutex = new java.util.concurrent.locks.ReentrantLock();
    public void accessCriticalSection() {
        mutex.lock();
        try {
            // Critical section code
        } finally {
            mutex.unlock();
        }
    }

    // Monitor example (only 1 thread can execute the method at a time)
    public synchronized void guardedMethod() {
        // Only one thread can execute this method at a time
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizationExamples example = new SynchronizationExamples();
        example.accessResource();
        example.accessCriticalSection();
        example.guardedMethod();
    }
}