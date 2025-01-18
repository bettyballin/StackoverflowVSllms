public class MutuallyExclusiveResource {
    Mutex mtx = new MutualExclusion();
    String resource;

    void write(String data){
        try {
            // acquire the mutex
            mtx.acquire();
            this.resource = data;   // Only one thread can execute this block due to Mutex
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // release the mutex
            mtx.release();
        }
    }

    public static void main(String[] args) {
        MutuallyExclusiveResource resource = new MutuallyExclusiveResource();
        // Example usage
        resource.write("Data");
    }
}

interface Mutex {
    void acquire() throws InterruptedException;
    void release();
}

class MutualExclusion implements Mutex {
    private boolean locked = false;

    public synchronized void acquire() throws InterruptedException {
        while (locked) {
            wait();
        }
        locked = true;
    }

    public synchronized void release() {
        locked = false;
        notify();
    }
}