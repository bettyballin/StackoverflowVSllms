import java.util.Random;

public class CpuLoadSimulator {

    public static void simulateCpuLoad(long durationInMillis) {
        long startTime = System.currentTimeMillis();
        long endTime = startTime + durationInMillis;
        
        Random random = new Random();

        while (System.currentTimeMillis() < endTime) {
            // Perform a variety of operations to keep CPU busy
            double a = random.nextDouble();
            double b = Math.sin(a);
            double c = Math.log(b * 10);
            int i = random.nextInt(10000);
            String s = Integer.toString(i) + Double.toString(c);
            
            // Simulate some additional work by reversing the string
            new StringBuilder(s).reverse().toString();
        }
    }

    public static void main(String[] args) {
        simulateCpuLoad(500);  // CPU load simulation for 500ms
    }
}