/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DataUpdater {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = this.lock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = this.lock.writeLock();

    public void updateData() {
        this.writeLock.lock();
        this.writeLock.unlock();
    }

    public List getData() {
        this.readLock.lock();
        try {
            List list = null;
            return list;
        }
        finally {
            this.readLock.unlock();
        }
    }

    public static void main(String[] stringArray) {
        DataUpdater dataUpdater = new DataUpdater();
        dataUpdater.updateData();
        dataUpdater.getData();
    }
}
