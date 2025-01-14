import java.lang.String;
public class SyncTest {
    public static void main(String[] args) {
        SyncTest test = new SyncTest();
        
        long startTime = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            test.nonSyncMethod();
        }
        long endTime = System.nanoTime();
        System.out.println("Non-Synchronized: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            test.syncMethod();
        }
        endTime = System.nanoTime();
        System.out.println("Synchronized: " + (endTime - startTime) + " ns");
    }

    public void nonSyncMethod() {
        // Simple operation
    }

    public synchronized void syncMethod() {
        // Simple operation
    }
}