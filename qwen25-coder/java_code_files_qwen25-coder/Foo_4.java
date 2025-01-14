// Foo.java
import java.lang.String;
public class Foo implements Runnable {
    private SharedObject shared;

    public Foo(SharedObject shared) {
        this.shared = shared;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000 && !shared.getShouldTerminate(); i++) {
            // thread logic here...
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
        }
        if(shared.getShouldTerminate()) {
            // Cleanup and exit
            System.out.println("Thread terminated externally");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SharedObject shared = new SharedObject();
        Thread fooTr = new Thread(new Foo(shared));
        fooTr.start();

        // Assuming Bar will set this once the license expires
        Thread.sleep(500);
        shared.setShouldTerminate(true);
    }
}

class SharedObject {
    private boolean shouldTerminate = false;

    public boolean getShouldTerminate() {
        return shouldTerminate;
    }

    public void setShouldTerminate(boolean shouldTerminate) {
        this.shouldTerminate = shouldTerminate;
    }
}