/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RootNodeFinder {
    private Set<Node> visited;
    private Set<Node> potentialRoots;

    public Set<Node> findRootNodes(Node node) {
        this.visited = new HashSet<Node>();
        this.potentialRoots = new HashSet<Node>();
        this.dfsTraversal(node);
        HashSet<Node> hashSet = new HashSet<Node>();
        for (Node node2 : this.potentialRoots) {
            if (!this.isRootNode(node2)) continue;
            hashSet.add(node2);
        }
        return hashSet;
    }

    private void dfsTraversal(Node node) {
        this.visited.add(node);
        if (node.children.isEmpty()) {
            this.potentialRoots.add(node);
        } else {
            for (Node node2 : node.children) {
                if (this.visited.contains(node2)) continue;
                this.dfsTraversal(node2);
            }
        }
    }

    private boolean isRootNode(Node node) {
        HashSet<Node> hashSet = new HashSet<Node>();
        return !this.hasParents(node, hashSet);
    }

    private boolean hasParents(Node node, Set<Node> set) {
        set.add(node);
        for (Node node2 : node.parents) {
            if (set.contains(node2) || this.hasParents(node2, set)) continue;
            return false;
        }
        return true;
    }

    public static void main(String[] stringArray) {
        RootNodeFinder rootNodeFinder = new RootNodeFinder();
        Node node = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        node.children.add(node2);
        node2.children.add(node3);
        node2.parents.add(node);
        node3.parents.add(node2);
        Set<Node> set = rootNodeFinder.findRootNodes(node);
        System.out.println("Root nodes: " + set.size());
    }

    private static class Node {
        List<Node> children = new ArrayList<Node>();
        List<Node> parents = new ArrayList<Node>();
    }
}
