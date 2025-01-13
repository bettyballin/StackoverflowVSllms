import java.lang.String;
public class Main_71 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        myFunction(); // Call the function you want to measure
        long endTime = System.nanoTime();

        long durationInNano = endTime - startTime;
        double durationInMilli = (double) durationInNano / 1_000_000; // convert to milliseconds

        System.out.println("Time taken by myFunction(): " + durationInMilli + " milliseconds");
    }

    public static void myFunction() {
        // Your function code here
        try {
            Thread.sleep(1000); // Example: simulate some delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}