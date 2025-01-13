/*
 * Decompiled with CFR 0.152.
 */
public class SimulationOptimizer {
    private int numIterations;
    private GraphicElement graphicElement;

    public void simulationLoopUnoptimized() {
        for (int i = 0; i < this.numIterations; ++i) {
            this.graphicElement.update();
        }
    }

    public void simulationLoopOptimized() {
        this.graphicElement.setCacheMode(true);
        for (int i = 0; i < this.numIterations; ++i) {
            if (i % 10 != 0) continue;
            this.graphicElement.update();
        }
    }

    public static void main(String[] stringArray) {
        SimulationOptimizer simulationOptimizer = new SimulationOptimizer();
        simulationOptimizer.numIterations = 100;
        simulationOptimizer.graphicElement = new GraphicElement();
        simulationOptimizer.simulationLoopUnoptimized();
        simulationOptimizer.simulationLoopOptimized();
    }
}
