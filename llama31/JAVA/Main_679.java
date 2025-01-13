import java.util.*;

class Node {
    private Set<Node> children;

    public Node() {
        this.children = new HashSet<>();
    }

    public void addChild(Node node) {
        children.add(node);
    }

    public Set<Node> getChildren() {
        return children;
    }
}

class Path {
    private List<Node> nodes;

    public Path() {
        this.nodes = new ArrayList<>();
    }

    public void add(Node node) {
        nodes.add(node);
    }

    public void remove(Node node) {
        nodes.remove(node);
    }

    public Path clone() {
        Path newPath = new Path();
        newPath.nodes.addAll(nodes);
        return newPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Path path = (Path) o;
        return nodes.equals(path.nodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodes);
    }
}

public class Main_679 {
    private Set<Node> startNodes;
    private Set<Path> result;

    public Main(Set<Node> startNodes) {
        this.startNodes = startNodes;
        this.result = new HashSet<>();
    }

    public void dfs(Node node, Path currentPath) {
        currentPath.add(node);
        if (startNodes.contains(node)) {
            // found a common node, add path to result
            result.add(currentPath.clone());
        }
        for (Node child : node.getChildren()) {
            dfs(child, currentPath);
        }
        currentPath.remove(node);
    }

    public static void main(String[] args) {
        // Example usage:
        Node node1 = new Node();
        Node node2 = new Node();
        node1.addChild(node2);

        Set<Node> startNodes = new HashSet<>();
        startNodes.add(node1);

        Main main = new Main(startNodes);
        main.dfs(node1, new Path());
    }
}