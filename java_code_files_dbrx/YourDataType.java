import java.util.concurrent.*;
import java.util.*;

class YourDataType {
    // Placeholder for your data type
}

public class DataUpdater {
    private final Semaphore lock = new Semaphore(1); // binary semaphore
    private List<YourDataType> dataList = new ArrayList<>();  // initialize your data list
    private boolean updatingData;

    public void updateData() throws InterruptedException {
        try {
            lock.acquire();   // acquire the lock, wait if it's not available
            updatingData = true;
            // update data here...
        } finally {
            updatingData = false;
            lock.release();  // always release the lock in a finally block to avoid deadlocks
        }
    }

    public List<YourDataType> getData() throws InterruptedException {
        while(updatingData) {  // check if update is ongoing, spin until it's finished
            Thread.sleep(20);  // wait for the updater to finish before trying again
        }
        lock.acquire();    // acquire the lock, block until available
        try {
            return Collections.unmodifiableList(dataList);  // clone or copy-on-write here...
        } finally {
            lock.release();   // always release the lock in a finally block to avoid deadlocks
        }
    }
}