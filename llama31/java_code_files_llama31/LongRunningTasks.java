/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;

public class LongRunningTasks {
    public void cpuIntensiveTask(int n) {
        for (int i = 0; i < n; ++i) {
            double d = Math.pow(Math.PI, 1000.0);
        }
    }

    public void generateRandomNumbers(int n) {
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < n; ++i) {
            secureRandom.nextLong();
        }
    }

    public void simulateNetworkLatency(int n) {
        for (int i = 0; i < n; ++i) {
            try {
                Thread.sleep(1L);
                continue;
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] stringArray) {
        LongRunningTasks longRunningTasks = new LongRunningTasks();
        longRunningTasks.cpuIntensiveTask(1000);
        longRunningTasks.generateRandomNumbers(1000);
        longRunningTasks.simulateNetworkLatency(1000);
    }
}
