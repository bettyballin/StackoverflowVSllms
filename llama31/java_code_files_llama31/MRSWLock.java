/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MRSWLock {
    private final Lock lock = new ReentrantLock();
    private final Condition readerCondition = this.lock.newCondition();
    private int readerCount = 0;
    private boolean writerActive = false;

    public void readLock() {
        this.lock.lock();
        try {
            while (this.writerActive) {
                this.readerCondition.await();
            }
            ++this.readerCount;
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
        finally {
            this.lock.unlock();
        }
    }

    public void readUnlock() {
        this.lock.lock();
        try {
            --this.readerCount;
            if (this.readerCount == 0) {
                this.readerCondition.signal();
            }
        }
        finally {
            this.lock.unlock();
        }
    }

    public void writeLock() {
        this.lock.lock();
        try {
            while (this.readerCount > 0) {
                this.readerCondition.await();
            }
            this.writerActive = true;
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
        finally {
            this.lock.unlock();
        }
    }

    public void writeUnlock() {
        this.lock.lock();
        try {
            this.writerActive = false;
            this.readerCondition.signalAll();
        }
        finally {
            this.lock.unlock();
        }
    }

    public static void main(String[] stringArray) {
        MRSWLock mRSWLock = new MRSWLock();
        mRSWLock.readLock();
        System.out.println("Read lock acquired");
        mRSWLock.readUnlock();
        System.out.println("Read lock released");
        mRSWLock.writeLock();
        System.out.println("Write lock acquired");
        mRSWLock.writeUnlock();
        System.out.println("Write lock released");
    }
}
