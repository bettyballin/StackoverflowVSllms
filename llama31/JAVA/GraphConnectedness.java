import java.util.*;

public class GraphConnectedness {
    private static class Edge {
        int u, v;

        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    private static class Graph {
        int numVertices;
        List<List<Edge>> adjList;

        Graph(int numVertices) {
            this.numVertices = numVertices;
            adjList = new ArrayList<>(numVertices);

            for (int i = 0; i < numVertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v) {
            adjList.get(u).add(new Edge(u, v));
            adjList.get(v).add(new Edge(v, u));
        }

        List<List<Edge>> findCycles() {
            List<List<Edge>> cycles = new ArrayList<>();
            boolean[] visited = new boolean[numVertices];
            int[] parent = new int[numVertices];

            for (int i = 0; i < numVertices; i++) {
                if (!visited[i]) {
                    dfs(i, visited, parent, cycles);
                }
            }

            return cycles;
        }

        private void dfs(int vertex, boolean[] visited, int[] parent, List<List<Edge>> cycles) {
            visited[vertex] = true;

            for (Edge edge : adjList.get(vertex)) {
                int neighbor = edge.v;

                if (!visited[neighbor]) {
                    parent[neighbor] = vertex;
                    dfs(neighbor, visited, parent, cycles);
                } else if (parent[vertex] != neighbor) {
                    // Cycle found
                    List<Edge> cycle = new ArrayList<>();
                    cycle.add(edge);

                    int currentVertex = vertex;
                    while (currentVertex != neighbor) {
                        int nextVertex = parent[currentVertex];
                        cycle.add(new Edge(currentVertex, nextVertex));
                        currentVertex = nextVertex;
                    }

                    cycles.add(cycle);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);

        List<List<Edge>> cycles = graph.findCycles();

        int waysToCut = 0;
        for (List<Edge> cycle : cycles) {
            int cycleSize = cycle.size();
            waysToCut += cycleSize * (cycleSize - 1) / 2;
        }

        System.out.println("Number of ways to cut 2 edges: " + waysToCut);
    }
}