import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class GenealogyGraph {
    private Map<String, List<String>> graph = new HashMap<String, List<String>>();

    // Add edges to the graph for testing
    public void addEdge(String horse, String ancestor) {
        if (!graph.containsKey(horse)) {
            graph.put(horse, new ArrayList<String>());
        }
        graph.get(horse).add(ancestor);
    }

    // Main function to detect cycles
    public boolean hasCycle(String start) {
        return dfs(start, new HashSet<String>(), new HashMap<String, String>());
    }

    private boolean dfs(String node, Set<String> visited, Map<String, String> recStack) {
        if (recStack.containsKey(node)) {
            return true; // Cycle detected
        }
        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);
        recStack.put(node, null);

        List<String> ancestors = graph.getOrDefault(node, new ArrayList<String>());
        for (String ancestor : ancestors) {
            if (dfs(ancestor, visited, recStack)) {
                return true;
            }
        }

        recStack.remove(node); // Backtrack
        return false;
    }

    public static void main(String[] args) {
        GenealogyGraph genealogyGraph = new GenealogyGraph();
        
        // Example of adding edges (horses and their ancestors)
        genealogyGraph.addEdge("Horse1", "Father1");
        genealogyGraph.addEdge("Father1", "Grandfather1");
        genealogyGraph.addEdge("Grandfather1", "GreatGrandfather1");
        // Uncomment the next line to test a cycle
        // genealogyGraph.addEdge("GreatGrandfather1", "Horse1");

        System.out.println(genealogyGraph.hasCycle("Horse1")); // Should return false unless cycle is introduced
    }
}