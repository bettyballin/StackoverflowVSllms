import java.lang.String;

public class Graph_1_1 {
    private int vertices;
    private int[][] adjacencyMatrix;

    public Graph_1(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int from, int to) {
        adjacencyMatrix[from][to] = 1;
    }

    public boolean isAcyclic() {
        boolean[] visited = new boolean[vertices];
        boolean[] recursionStack = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, recursionStack)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCyclicUtil(int vertex, boolean[] visited, boolean[] recursionStack) {
        visited[vertex] = true;
        recursionStack[vertex] = true;

        for (int i = 0; i < vertices; i++) {
            if (adjacencyMatrix[vertex][i] == 1) {
                if (!visited[i]) {
                    if (isCyclicUtil(i, visited, recursionStack)) {
                        return true;
                    }
                } else if (recursionStack[i]) {
                    return true;
                }
            }
        }

        recursionStack[vertex] = false;
        return false;
    }

	public static void main(String[] args) {
		Graph_1 graph = new Graph_1(4);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		System.out.println("Is the graph acyclic? " + graph.isAcyclic());
	}
}