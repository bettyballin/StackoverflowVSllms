import java.lang.String;

public class Monitor {
    private int varX;
    private boolean occupied = false;

    public synchronized void taskA() {
        while (occupied) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        occupied = true;
        // manipulate varX
        occupied = false;
        notifyAll();
    }

    public synchronized void taskB() {
        while (occupied) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        occupied = true;
        // manipulate varX
        occupied = false;
        notifyAll();
    }

    public static void main(String[] args) {
        // Create an instance of the Monitor class to avoid the "unused" warning
        Monitor monitor = new Monitor();
    }
}