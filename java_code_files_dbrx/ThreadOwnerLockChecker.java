import java.lang.String;

public class ThreadOwnerLockChecker {
    private MyLock myLock = new MyLock();

    public void foo() {
        myLock.lock();  // block until condition holds
        try {
            if (myLock.getOwner() != null && !myLock.getOwner().toString().equals(Thread.currentThread().toString())) {
                System.out.println("Synchronization violation detected: " + Thread.currentThread());
            }
            // ... method body
        } finally {
            myLock.unlock();  // release lock
        }
    }

    public static void main(String[] args) {
        ThreadOwnerLockChecker checker = new ThreadOwnerLockChecker();
        checker.foo();
    }
}

class MyLock {
    private Thread owner = null;

    public synchronized void lock() {
        while (owner != null && owner != Thread.currentThread()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        owner = Thread.currentThread();
    }

    public synchronized void unlock() {
        if (owner == Thread.currentThread()) {
            owner = null;
            notifyAll();
        } else {
            throw new IllegalMonitorStateException("Current thread does not own the lock");
        }
    }

    public synchronized Thread getOwner() {
        return owner;
    }
}