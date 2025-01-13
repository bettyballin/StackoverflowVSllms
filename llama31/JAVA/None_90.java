import java.lang.String;

public class None_90_90 {
    int[][] graph = {
        {1, 2}, // Node A
        {3, 4}, // Node B
        {5}, // Node D
        {}, // Node E
        {} // Node F
    };

    int[] weights = {3, 4, 7, 2, 3};

    public static void main(String[] args) {
        None_90 instance = new None_90();
        int[] criticalPath = CriticalPath.computeCriticalPath(instance.graph, instance.weights);

        System.out.println("Critical Path: ");
        for (int i = criticalPath.length - 1; i >= 0; i--) {
            System.out.print(criticalPath[i] + " ");
        }
    }
}

class CriticalPath {
    public static int[] computeCriticalPath(int[][] graph, int[] weights) {
        // Implementation of computeCriticalPath method is missing in the original code.
        // Here, I'm providing a basic implementation for demonstration purposes.
        int[] criticalPath = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            criticalPath[i] = i;
        }
        return criticalPath;
    }
}