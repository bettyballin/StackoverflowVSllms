/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashSet;
import java.util.LinkedList;

public class KevinBaconNumber {
    public static int calculateKevinBaconNumber(Graph graph, Node node, Node node2) {
        Node node3;
        int n;
        int n2;
        HashSet<Node> hashSet = new HashSet<Node>();
        LinkedList<Node> linkedList = new LinkedList<Node>();
        linkedList.add(node);
        hashSet.add(node);
        int n3 = 0;
        while (!linkedList.isEmpty()) {
            n2 = linkedList.size();
            for (n = 0; n < n2; ++n) {
                node3 = (Node)linkedList.poll();
                if (node3.equals(node2)) {
                    return n3;
                }
                for (Node node4 : graph.getNeighbors(node3)) {
                    if (hashSet.contains(node4)) continue;
                    linkedList.add(node4);
                    hashSet.add(node4);
                }
            }
            ++n3;
        }
        linkedList.clear();
        linkedList.add(node2);
        hashSet.clear();
        hashSet.add(node2);
        n3 = 0;
        while (!linkedList.isEmpty()) {
            n2 = linkedList.size();
            for (n = 0; n < n2; ++n) {
                node3 = (Node)linkedList.poll();
                if (node3.equals(node)) {
                    return n3;
                }
                for (Node node4 : graph.getNeighbors(node3)) {
                    if (hashSet.contains(node4)) continue;
                    linkedList.add(node4);
                    hashSet.add(node4);
                }
            }
            ++n3;
        }
        return -1;
    }

    public static void main(String[] stringArray) {
        Graph graph = new Graph();
        Node node = new Node("Kevin Bacon");
        Node node2 = new Node("Tom Hanks");
        Node node3 = new Node("Meg Ryan");
        graph.addNode(node);
        graph.addNode(node2);
        graph.addNode(node3);
        graph.addEdge(node, node3);
        graph.addEdge(node3, node2);
        int n = KevinBaconNumber.calculateKevinBaconNumber(graph, node, node2);
        System.out.println("Kevin Bacon Number: " + n);
    }
}
