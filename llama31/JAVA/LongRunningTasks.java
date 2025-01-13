import java.lang.String;
import java.security.SecureRandom;
import java.util.Random;

public class LongRunningTasks {
    public void cpuIntensiveTask(int iterations) {
        for (int i = 0; i < iterations; i++) {
            // Perform some CPU-intensive calculations
            double result = Math.pow(Math.PI, 1000);
        }
    }

    public void generateRandomNumbers(int iterations) {
        Random rand = new SecureRandom();
        for (int i = 0; i < iterations; i++) {
            // Generate a random number
            rand.nextLong();
        }
    }

    public void simulateNetworkLatency(int iterations) {
        for (int i = 0; i < iterations; i++) {
            // Simulate network latency by sleeping for a short duration
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        LongRunningTasks tasks = new LongRunningTasks();
        tasks.cpuIntensiveTask(1000);
        tasks.generateRandomNumbers(1000);
        tasks.simulateNetworkLatency(1000);
    }
}