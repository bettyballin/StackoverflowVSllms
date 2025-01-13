/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    public static List<Node> shortestPath(Graph graph, Node node, Node node2) {
        ArrayList<Node> arrayList;
        Object object2;
        HashMap<Node, Integer> hashMap = new HashMap<Node, Integer>();
        HashMap<Node, ArrayList<Node>> hashMap2 = new HashMap<Node, ArrayList<Node>>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>();
        priorityQueue.add(node);
        for (Object object2 : graph.getNodes()) {
            hashMap.put((Node)object2, Integer.MAX_VALUE);
        }
        hashMap.put(node, 0);
        while (!priorityQueue.isEmpty()) {
            arrayList = (Node)priorityQueue.poll();
            for (Edge edge : graph.getEdges((Node)((Object)arrayList))) {
                int n = (Integer)hashMap.get(arrayList) + edge.getWeight();
                if (n >= (Integer)hashMap.get(edge.getDestination())) continue;
                hashMap.put(edge.getDestination(), n);
                hashMap2.put(edge.getDestination(), arrayList);
                priorityQueue.add(edge.getDestination());
            }
        }
        arrayList = new ArrayList<Node>();
        object2 = node2;
        while (object2 != node) {
            arrayList.add(0, (Node)object2);
            object2 = (Node)hashMap2.get(object2);
        }
        arrayList.add(0, node);
        return arrayList;
    }

    public static void main(String[] stringArray) {
    }
}
