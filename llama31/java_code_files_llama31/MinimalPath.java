/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MinimalPath {
    public static List<String> bfs(Graph graph, String string, String string2) {
        LinkedList<String> linkedList = new LinkedList<String>();
        HashSet<String> hashSet = new HashSet<String>();
        HashMap<String, String> hashMap = new HashMap<String, String>();
        linkedList.add(string);
        hashSet.add(string);
        while (!linkedList.isEmpty()) {
            String string3 = (String)linkedList.poll();
            if (string3.equals(string2)) {
                ArrayList arrayList = new ArrayList();
                while (string3 != null) {
                    arrayList.add(string3);
                    string3 = (String)hashMap.get(string3);
                }
                Collections.reverse(arrayList);
                return arrayList;
            }
            for (String string4 : graph.getNeighbors(string3)) {
                if (hashSet.contains(string4)) continue;
                linkedList.add(string4);
                hashSet.add(string4);
                hashMap.put(string4, string3);
            }
        }
        return null;
    }

    public static void main(String[] stringArray) {
        Graph graph = new Graph();
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        List<String> list = MinimalPath.bfs(graph, "A", "C");
        System.out.println(list);
    }
}
