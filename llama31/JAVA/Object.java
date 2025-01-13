public class CustomObject {

    @Override
    public Class<?> getClass() {
        return this.getClass();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public final void notify() {
        synchronized (this) {
            this.notify();
        }
    }

    public final void notifyAll() {
        synchronized (this) {
            this.notifyAll();
        }
    }

    public final void wait(long timeout) throws InterruptedException {
        synchronized (this) {
            this.wait(timeout);
        }
    }

    public final void wait(long timeout, int nanos) throws InterruptedException {
        synchronized (this) {
            this.wait(timeout, nanos);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public static void main(String[] args) {
    }
}