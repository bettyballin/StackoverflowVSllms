import java.lang.String;
public abstract class DiameterFinderorDijkstraDiameterCalculatorwouldbesuitableclassnamesforthisJavacode {
    public double findDiameter() {
        // Step 1: Run Dijkstra’s algorithm from an arbitrary starting node (0)
        double[] distancesFromFirstRun = distancesFrom(0);

        // Find the farthest node from the initial start node.
        int farthestNode = 0;
        for (int i = 1; i < size(); i++) {
            if (distancesFromFirstRun[i] > distancesFromFirstRun[farthestNode]) {
                farthestNode = i;
            }
        }

        // Step 2: Run Dijkstra’s algorithm from the farthest node found.
        double[] distancesFromSecondRun = distancesFrom(farthestNode);

        // The longest distance in this result set is the diameter of your graph
        double diameter = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < size(); i++) {
            if (distancesFromSecondRun[i] > diameter) {
                diameter = distancesFromSecondRun[i];
            }
        }

        return diameter;
    }

    protected abstract double[] distancesFrom(int node);

    protected abstract int size();

    public static void main(String[] args) {
    }
}