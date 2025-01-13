import java.util.HashSet;
import java.util.Set;

class Horse {
    public Set<Horse> getParents() {
        // Implementation of getParents method is assumed to exist
        return new HashSet<>();
    }
}

public class GenealogyGraph {
    private Set<Horse> visited = new HashSet<>();

    public void dfs(Horse horse) {
        if (visited.contains(horse)) {
            // Cycle detected! Stop recursion.
            return;
        }
        visited.add(horse);

        // Recursively visit parents
        for (Horse parent : horse.getParents()) {
            dfs(parent);
        }

        // Backtrack: remove horse from visited set
        visited.remove(horse);
    }

    public static void main(String[] args) {
    }
}