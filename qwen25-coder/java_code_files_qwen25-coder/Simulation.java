import java.util.Arrays;
import java.util.Random;

// Java example for a simple simulation with mutable state
public class Simulation {
    private int[] entities;
    private boolean running;
    private Random rand;

    public Simulation(int size) {
        this.entities = new int[size];
        // Initialize entities with random values or states
        this.rand = new Random();
    }

    public void step() {
        if (!running) return;
        for (int i = 0; i < entities.length; i++) {
            // Update each entity's state based on rules
            entities[i] += rand.nextInt(10) - 5; // Simplified rule
        }
        checkEndCondition(); // Determine if simulation should end
    }

    private void checkEndCondition() {
        // Example condition: Stop when all entities reach a certain value
        boolean allStopped = true;
        for (int entity : entities) {
            if (entity != 0) {
                allStopped = false;
                break;
            }
        }
        this.running = !allStopped;
    }

    public static void main(String[] args) {
        Simulation sim = new Simulation(10);
        while (sim.running) {
            sim.step();
            System.out.println(Arrays.toString(sim.entities));
        }
        System.out.println("Simulation ended.");
    }
}