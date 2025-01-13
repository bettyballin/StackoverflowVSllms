import java.lang.String;

public class SimulationOptimizer {
    private int numIterations;
    private GraphicElement graphicElement;

    // Unoptimized implementation
    public void simulationLoopUnoptimized() {
        for (int i = 0; i < numIterations; i++) {
            // Perform computations...
            graphicElement.update(); // Update graphics for each iteration
        }
    }

    // Optimized implementation
    public void simulationLoopOptimized() {
        // Cache graphic updates
        graphicElement.setCacheMode(true);

        for (int i = 0; i < numIterations; i++) {
            // Perform computations...
            if (i % 10 == 0) { // Update graphics every 10 iterations
                graphicElement.update();
            }
        }
    }

    public static void main(String[] args) {
        SimulationOptimizer optimizer = new SimulationOptimizer();
        optimizer.numIterations = 100; // Set number of iterations
        optimizer.graphicElement = new GraphicElement(); // Initialize graphic element

        optimizer.simulationLoopUnoptimized();
        optimizer.simulationLoopOptimized();
    }
}

// Assuming GraphicElement class is defined elsewhere
class GraphicElement {
    private boolean cacheMode;

    public void setCacheMode(boolean cacheMode) {
        this.cacheMode = cacheMode;
    }

    public void update() {
        // Graphic update implementation
    }
}