import java.util.*;
import java.util.stream.*;

class TreeNode {
    int id;
    Collection<TreeNode> parents, children;
}

public class Main_125 {
    // Function to generate and print link chains
    public static void dfs(Map<Integer, Boolean> visited, TreeNode node, List<Integer> chain) {
        if (!visited.getOrDefault(node.id, false)) {
            visited.put(node.id, true);
            chain.add(node.id);
            for (TreeNode parent : node.parents) {
                dfs(visited, parent, new ArrayList<>(chain)); // For each parent, start a new chain with the current chain
            }
            for (TreeNode child : node.children){
                if (!child.equals(node)) { // Avoid self-reference loops
                    dfs(visited, child, new ArrayList<>(chain)); // For each child, start a new chain with the current chain
                }
            }
        } else {
            System.out.println("Chain: " + chain.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" - "))); // Print chains if node is already visited and adding it will create a loop
        }
    }

    public static void main(String[] args) {
    }
}