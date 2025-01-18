import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Resource {
    ReadWriteLock lock = new ReentrantReadWriteLock();
    String resource;

    void read() {
        lock.readLock().lock();
        try {
            // code to read from the resource
        } finally {
            lock.readLock().unlock();
        }
    }

    void write(String data) {
        lock.writeLock().lock();
        try {
            this.resource = data;
        } finally {
            lock.writeLock().unlock();
        }
    }
}