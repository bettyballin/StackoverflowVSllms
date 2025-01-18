import java.util.Map;
import java.util.Set;

public class DominatorNode {
    int id; // node index/id
    Map<Integer, Set<Integer>> inBoundGraphEdges; // map of neighbor ids with set of incoming edge keys from the corresponding nodes
    Integer parentIdom; // immediate dominator parent id for this node (null if root)

    public static void main(String[] args) {
    }
}