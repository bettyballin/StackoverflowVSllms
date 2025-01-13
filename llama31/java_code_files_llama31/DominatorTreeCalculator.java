/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashSet;
import java.util.Set;

public class DominatorTreeCalculator {
    public static void calculateDominatorTreeForChild(Graph graph, Node node, Node node2) {
        Graph graph2 = DominatorTreeCalculator.removeRootNode(graph, node);
        DominatorTreeCalculator.updateIdomValues(graph2, node2);
        DominatorTreeCalculator.dfsTraversal(graph2, node2);
        DominatorTree dominatorTree = DominatorTreeCalculator.calculateDominatorTree(graph2);
    }

    private static Graph removeRootNode(Graph graph, Node node) {
        Graph graph2 = new Graph();
        for (Object object : graph.getNodes()) {
            if (object == node) continue;
            graph2.addNode((Node)object);
        }
        for (Object object : graph.getEdges()) {
            if (object.getTarget() == node) continue;
            graph2.addEdge((Edge)object);
        }
        return graph2;
    }

    private static void updateIdomValues(Graph graph, Node node) {
        for (Node node2 : graph.getNodes()) {
            if (node2.getIdom() != graph.getRoot()) continue;
            node2.setIdom(node);
        }
    }

    private static void dfsTraversal(Graph graph, Node node) {
        HashSet<Node> hashSet = new HashSet<Node>();
        DominatorTreeCalculator.dfsTraversalHelper(graph, node, hashSet);
    }

    private static void dfsTraversalHelper(Graph graph, Node node, Set<Node> set) {
        set.add(node);
        for (Node node2 : graph.getNeighbors(node)) {
            if (set.contains(node2)) continue;
            DominatorTreeCalculator.dfsTraversalHelper(graph, node2, set);
            if (node2.getIdom() == node) continue;
            node2.setIdom(node);
        }
    }

    private static DominatorTree calculateDominatorTree(Graph graph) {
        return new DominatorTree();
    }

    public static void main(String[] stringArray) {
        Node node = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Edge edge = new Edge(node, node2);
        Edge edge2 = new Edge(node2, node3);
        Graph graph = new Graph();
        graph.addNode(node);
        graph.addNode(node2);
        graph.addNode(node3);
        graph.addEdge(edge);
        graph.addEdge(edge2);
        graph.setRoot(node);
        DominatorTreeCalculator.calculateDominatorTreeForChild(graph, node, node2);
    }
}
