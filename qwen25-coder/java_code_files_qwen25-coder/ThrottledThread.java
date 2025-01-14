public class ThrottledThread extends Thread {
    private int delay;

    public ThrottledThread(int delay) {
        this.delay = delay;
    }

    @Override
    public void run() {
        while (true) {
            // Perform some work here
            try {
                // Simulate CPU-intensive task
                for (int i = 0; i < 1000000; i++) {
                    Math.sqrt(i);
                }
                Thread.sleep(delay); // Sleep for `delay` milliseconds to reduce CPU usage
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
                break;
            }
        }
    }

    public static void main(String[] args) {
        ThrottledThread thread = new ThrottledThread(50); // Sleep for 50 ms between iterations
        thread.setPriority(Thread.MIN_PRIORITY); // Set the lowest priority
        thread.start();
    }
}