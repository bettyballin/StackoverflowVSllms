import java.util.*;

public class StudentOrdering {
    public static int minRows(List<List<Integer>> adjList) {
        int n = adjList.size();
        // Calculate in-degrees for all vertices
        int[] inDegree = new int[n];
        
        // Construct the graph and calculate in-degree
        for (int i = 0; i < n; ++i) {
            for (int j : adjList.get(i)) {
                inDegree[j]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        
        // Initialize queue with all vertices having 0 in-degree
        for (int i = 0; i < n; ++i) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int rowsNeeded = 0;

        boolean[] visited = new boolean[n];
        while (!q.isEmpty()) {
            int size = q.size();
            
            // Increment row count for each level of BFS
            rowsNeeded++;
            
            // Process all nodes at the current depth (row)
            for (int i = 0; i < size; ++i) {
                int u = q.poll();
                
                visited[u] = true;
                
                // Decrease in-degree of adjacent vertices and enqueue if any becomes zero
                for (int v : adjList.get(u)) {
                    inDegree[v]--;
                    
                    if (inDegree[v] == 0 && !visited[v]) {
                        q.add(v);
                    }
                }
            }
        }
        
        return rowsNeeded;
    }

    public static void main(String[] args) {
        // Example
        List<List<Integer>> adjList = new ArrayList<>(); // Adjacency list representation of the graph
        int numStudents = 5; // Number of students
        
        for (int i = 0; i < numStudents; ++i) {
            adjList.add(new ArrayList<>());
        }
        
        // Adding hate relationships i -> j
        adjList.get(0).add(1); // Student 0 hates student 1
        adjList.get(0).add(2); // Student 0 hates student 2
        adjList.get(1).add(3); // Student 1 hates student 3
        adjList.get(2).add(3); // Student 2 hates student 3
        adjList.get(3).add(4); // Student 3 hates student 4
        
        System.out.println("Minimum rows needed: " + minRows(adjList)); // Output should be minimum rows
    }
}