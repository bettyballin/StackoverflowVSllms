import javax.swing.Timer;

public class TimerExample {

    private static long startTime = System.currentTimeMillis();

    public static void main(String[] args) {

        Timer timer = new Timer(1000, e -> {
            long currentTime = System.currentTimeMillis();
            long timeInMilliseconds = currentTime - startTime;
            long timeInSeconds = timeInMilliseconds / 1000;
            System.out.println("Time elapsed: " + timeInSeconds + " seconds");
        });
        timer.start();

        // Keep the program running to allow the timer to function
        try {
            // Let the timer run for 10 seconds
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        // Stop the timer after 10 seconds
        timer.stop();
        
        // To stop the timer at a certain point, you can call:
        // timer.stop();
    }
}