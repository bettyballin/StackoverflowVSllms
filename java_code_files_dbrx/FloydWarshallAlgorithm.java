import java.util.ArrayList;
import java.util.Arrays;

public class FloydWarshallAlgorithm {

    private int numberOfNodes;
    private double[][] weightArray;

    public void floydWarshall() {
        // Initialize each pair of nodes' distance with infinity
        int n = numberOfNodes;
        weightArray = new double[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(weightArray[i], Double.MAX_VALUE);
        }

        // Fill in the edges and nodes' cost
        ArrayList<Edge> edgeList = getEdges();
        for (Edge e : edgeList) {
            weightArray[e.from][e.to] = e.weight;
            weightArray[e.to][e.from] = e.weight;  // The graph is undirected, so add the cost both ways
        }

        for (int k = 0; k < n; k++) {   // This represents the intermediate vertex i-k-j traversal path
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    if ((weightArray[i][k] != Double.MAX_VALUE) && (weightArray[k][j] != Double.MAX_VALUE)) { // Check if the path has been previously calculated or not
                        weightArray[i][j] = Math.min(weightArray[i][j], Math.abs(weightArray[i][k]) + Math.abs(weightArray[k][j])); // This is for longest distance, you can use `+` if it's shortest path instead
                    }
                }
            }
        }
    }

    private ArrayList<Edge> getEdges() {
        return new ArrayList<Edge>();
    }

    public static void main(String[] args) {
    }

    class Edge {
        int from;
        int to;
        double weight;
    }
}