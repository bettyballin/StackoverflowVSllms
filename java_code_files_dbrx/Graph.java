import java.util.*;

public class Graph {
    // Adapted Dijkstra's algorithm to find the minimum number of edges between nodes (i.e., shortest path in terms of length)

    public int[] dijkstrasEdgeCount(int startNode, List<List<Integer>> adjacencyList) {
        int n = adjacencyList.size(); // size of graph
        boolean visitedSet[] = new boolean[n];

        int edgeCounts[] = new int[n];  // count the num edges to the destination node (initially set as infinity)
        Arrays.fill(edgeCounts, Integer.MAX_VALUE);

        edgeCounts[startNode] = 0;

        // Priority queue where the element with least number of edges comes first
        PriorityQueue<Integer> Q = new PriorityQueue<>(Comparator.comparingInt(i -> edgeCounts[i]));

        Q.add(startNode);

        while (!Q.isEmpty()) {  // pop the element with least edges and push its neighbors into the queue (if not visited)
            int current = Q.poll();
            if (visitedSet[current]) continue;
            visitedSet[current] = true;
            for (int neighbor : adjacencyList.get(current)) {
                if (!visitedSet[neighbor] && edgeCounts[neighbor] > edgeCounts[current] + 1){
                    edgeCounts[neighbor] = edgeCounts[current] + 1;
                    Q.add(neighbor);
                }
            }
        }
        return edgeCounts; // returns number of edges to each node from startNode or Integer.MAX_VALUE if no path exists
    }
}