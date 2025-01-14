import java.util.concurrent.Semaphore;

public class PizzaExample {
    // Semaphore example
    class PizzaWithSemaphore {
        Semaphore sem = new Semaphore(1); // Binary semaphore for one pizza

        void eatPizza() {
            try {
                sem.acquire(); // Wait until it's possible to enter the fridge
                synchronized (this) {  // Simulating critical section control
                    System.out.println(Thread.currentThread().getName() + " is eating pizza.");
                    Thread.sleep(100); // Simulating time taken to eat
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                sem.release(); // Free up the semaphore for others
            }
        }
    }

    // Monitor example
    class PizzaWithMonitor {
        public synchronized void eatPizza() { // Only one thread can enter at a time
            System.out.println(Thread.currentThread().getName() + " is eating pizza.");
            try {
                Thread.sleep(100); // Simulating time taken to eat
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
    }
}