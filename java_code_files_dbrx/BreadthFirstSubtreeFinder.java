import java.util.Set;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Collections;

public class BreadthFirstSubtreeFinder {

    public Map<Integer, List<Integer>> findSubtree(List<Node> allNodes, Node root) {
        if (root == null || allNodes == null || allNodes.isEmpty()) {
            return Collections.emptyMap();
        }

        // Breadth-first search with a queue and a visited set to store nodes we've traversed already
        Map<Integer, List<Integer>> result = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visitedSet = new HashSet<>();

        // Add root to the BFS queue and visited set initially
        queue.add(root);
        visitedSet.add(root);

        // Traverse the graph in a breadth-first manner until all nodes are processed
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            updateResultWithSubtree(currentNode, result, visitedSet);

            if (currentNode.getParent() != null) { // Only proceed to traverse parent node's sub-nodes when unidirectional tree is available starting from the root
                addToQueueAndVisitedCollection(result, queue, visitedSet, currentNode.getParent());
            }
        }

        return result;
    }

    private void updateResultWithSubtree(Node node, Map<Integer, List<Integer>> resultMap, Set<Node> visitedNodes) {
        if (node != null && !visitedNodes.contains(node)) { // Only proceed with the current node and its sub-trees when they have not already been processed before
            int id = node.getId();
            List<Integer> nodesInSubtreeIdList = new ArrayList<>();
            resultMap.put(id, nodesInSubtreeIdList);

            addToResultIfNotVisitedBefore(resultMap, visitedNodes, node.getParent()); // Add parent to children's sub-trees
            updateNodeIdsRecursively(node, visitedNodes, nodesInSubtreeIdList);
        }
    }

    private void addToQueueAndVisitedCollection(Map<Integer, List<Integer>> result, Queue<Node> queue, Set<Node> visitedSet, Node node) {
        if (node != null && !visitedSet.contains(node)) { // Prevent re-visit when a circular reference is found in the tree data structure
            visitedSet.add(node);
            updateResultWithSubtree(node, result, visitedSet);
            queue.add(node);
        }
    }

    private void addToResultIfNotVisitedBefore(Map<Integer, List<Integer>> resultMap, Set<Node> visitedNodes, Node node) {
        if (node != null && !visitedNodes.contains(node)) {
            int id = node.getId();
            List<Integer> nodesInSubtreeIdList = new ArrayList<>();
            resultMap.put(id, nodesInSubtreeIdList);
            visitedNodes.add(node);
            updateNodeIdsRecursively(node, visitedNodes, nodesInSubtreeIdList);
        }
    }

    private void updateNodeIdsRecursively(Node node, Set<Node> visitedNodes, List<Integer> nodesInSubtreeIdList) {
        if (node != null && !visitedNodes.contains(node)) {
            visitedNodes.add(node);
            nodesInSubtreeIdList.add(node.getId());
            for (Node child : node.getChildren()) {
                updateNodeIdsRecursively(child, visitedNodes, nodesInSubtreeIdList);
            }
        }
    }

    public static void main(String[] args) {
        // You can add code here to test the BreadthFirstSubtreeFinder
    }
}

class Node {
    private int id;
    private Node parent;
    private List<Node> children;

    public Node(int id) {
        this.id = id;
        this.children = new ArrayList<>();
    }

    public Node(int id, Node parent) {
        this(id);
        this.parent = parent;
        if (parent != null) {
            parent.addChild(this);
        }
    }

    public int getId() {
        return id;
    }

    public Node getParent() {
        return parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    private void addChild(Node child) {
        children.add(child);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return id == node.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}