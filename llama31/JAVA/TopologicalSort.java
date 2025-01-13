import java.util.*;

public class TopologicalSort {
    public static List<String> sort(Map<String, List<String>> dependencies) {
        List<String> sorted = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        for (String node : dependencies.keySet()) {
            if (!visited.contains(node)) {
                visit(node, dependencies, visited, sorted);
            }
        }

        return sorted;
    }

    private static void visit(String node, Map<String, List<String>> dependencies, Set<String> visited, List<String> sorted) {
        visited.add(node);

        for (String neighbor : dependencies.get(node)) {
            if (!visited.contains(neighbor)) {
                visit(neighbor, dependencies, visited, sorted);
            }
        }

        sorted.add(node);
    }

    public static void main(String[] args) {
        Map<String, List<String>> dependencies = new HashMap<>();
        dependencies.put("A", Arrays.asList("B", "D"));
        dependencies.put("D", Arrays.asList("B", "C"));
        dependencies.put("B", Arrays.asList("C", "E"));
        dependencies.put("C", Collections.emptyList());
        dependencies.put("E", Collections.emptyList());

        List<String> sorted = sort(dependencies);
        System.out.println(sorted); // [E, C, B, D, A]
    }
}