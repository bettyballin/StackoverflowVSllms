import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1); // initialize the semaphore with 1 permit

        // TaskA begins manipulating varX, other tasks wait until TaskA finishes
        try {
            sem.acquire(); // equivalent to waiting for a green signal
            try {
                updateVarX(); // critical section - manipulation of varX by one task at a time
            } finally {
                sem.release(); // allowing the next vehicle (task) to proceed with resource access
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Other tasks are repeated using the same principle above
    }

    private static void updateVarX() {
        // critical section - manipulation of varX by one task at a time
        // Example operation on varX
        System.out.println("varX updated.");
    }
}