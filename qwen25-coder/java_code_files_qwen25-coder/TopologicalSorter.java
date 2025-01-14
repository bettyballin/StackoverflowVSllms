import java.util.*;

public class TopologicalSorter {
    public static List<String> topologicalSort(Map<String, List<String>> graph) {
        // Map to store the in-degree of each node
        Map<String, Integer> inDegree = new HashMap<>();
        
        // Initialize the map with all nodes having zero in-degrees
        for (String node : graph.keySet()) {
            inDegree.put(node, 0);
        }
        
        // Compute in-degree for each node
        for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
            String fromNode = entry.getKey();
            for (String toNode : entry.getValue()) {
                inDegree.put(toNode, inDegree.getOrDefault(toNode, 0) + 1);
            }
        }
        
        // Queue to keep track of nodes with zero in-degree
        Queue<String> queue = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }
        
        List<String> sortedList = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            String node = queue.remove();
            sortedList.add(node);
            
            // Reduce the in-degree of adjacent nodes
            for (String adjacent : graph.getOrDefault(node, new LinkedList<String>())) {
                int degree = inDegree.get(adjacent) - 1;
                inDegree.put(adjacent, degree);
                
                if (degree == 0) {
                    queue.add(adjacent);
                }
            }
        }
        
        // If the sorted list has fewer elements than the number of nodes,
        // then it means there was a cycle in our graph.
        if (sortedList.size() < graph.keySet().size()) {
            throw new RuntimeException("Graph contains cycle");
        }
        
        return sortedList;
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "D"));
        graph.put("D", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("C", "E"));

        // C and E have no dependencies
        graph.put("C", Collections.emptyList());
        graph.put("E", Collections.emptyList());

        List<String> sortedOrder = topologicalSort(graph);
        System.out.println(sortedOrder);  // Output: [E, C, B, D, A]
    }
}