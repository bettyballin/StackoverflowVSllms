import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main_102 {
    public static void main(String[] args) {
        // Assuming alg and execPanel are arrays of some class and are properly initialized
        Alg[] alg = new Alg[10]; 
        ExecPanel[] execPanel = new ExecPanel[10]; 

        // Initialize alg and execPanel arrays
        for (int i = 0; i < 10; i++) {
            alg[i] = new Alg();
            execPanel[i] = new ExecPanel();
        }

        Lock lock = new ReentrantLock();

        while (true) {
            lock.lock();
            try {
                for (int i = 0; i < alg.length; i++) {
                    if (execPanel[i].isReset()) {
                        alg[i].terminate();
                        createProgram(i);
                        alg[i].start();
                        execPanel[i].unreset();
                    }
                }
            } finally {
                lock.unlock();
            }
            try {
                Thread.sleep(100); // adjust the delay as needed
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Assuming createProgram is a method that creates a program for the given index
    public static void createProgram(int index) {
        System.out.println("Creating program for index " + index);
        // Replace with actual implementation
    }
}

// Assuming Alg and ExecPanel are classes with the required methods
class Alg {
    public void terminate() {
        System.out.println("Terminating Alg");
    }
    public void start() {
        System.out.println("Starting Alg");
    }
}

class ExecPanel {
    private boolean reset = false;

    public boolean isReset() {
        return reset;
    }
    public void unreset() {
        reset = false;
    }
    public void setReset() {
        reset = true;
    }
}