public class SpikeTestSimulator {
    // Example: Simulating spike test in Java

    public static void main(String[] args) {
        int normalLoad = 100;
        int spikeLoad = 500;
        simulateLoad(normalLoad);
        simulateLoad(spikeLoad);  // Spike
        simulateLoad(normalLoad);
    }

    static void simulateLoad(int load) {
        System.out.println("Simulating load: " + load);
    }
}