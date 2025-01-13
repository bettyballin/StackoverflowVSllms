/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SequenceCounter {
    private long currentValue;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = this.lock.readLock();
    private final Lock writeLock = this.lock.writeLock();

    public long getNextValue() {
        this.writeLock.lock();
        try {
            if (this.currentValue < Long.MAX_VALUE) {
                long l = this.currentValue++;
                return l;
            }
            long l = Long.MAX_VALUE;
            return l;
        }
        finally {
            this.writeLock.unlock();
        }
    }

    public void updateCurrentValue(long l) {
        this.writeLock.lock();
        try {
            this.currentValue = l;
        }
        finally {
            this.writeLock.unlock();
        }
    }

    public static void main(String[] stringArray) {
        SequenceCounter sequenceCounter = new SequenceCounter();
        sequenceCounter.updateCurrentValue(10L);
        System.out.println(sequenceCounter.getNextValue());
        System.out.println(sequenceCounter.getNextValue());
    }
}
