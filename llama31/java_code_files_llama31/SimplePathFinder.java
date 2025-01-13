/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SimplePathFinder {
    public static void main(String[] stringArray) {
        Graph graph = new Graph();
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("B", "E");
        graph.addEdge("B", "F");
        graph.addEdge("C", "E");
        graph.addEdge("C", "F");
        graph.addEdge("D", "B");
        graph.addEdge("E", "C");
        graph.addEdge("E", "F");
        graph.addEdge("F", "B");
        graph.addEdge("F", "C");
        graph.addEdge("F", "E");
        List<List<String>> list = graph.findSimplePaths("B", "E");
        for (List<String> list2 : list) {
            System.out.println(String.join((CharSequence)" -> ", list2));
        }
    }

    private static class Graph {
        private final Map<String, List<String>> adjacencyList = new HashMap<String, List<String>>();

        public void addEdge(String string2, String string3) {
            this.adjacencyList.computeIfAbsent(string2, string -> new ArrayList()).add(string3);
            this.adjacencyList.computeIfAbsent(string3, string -> new ArrayList()).add(string2);
        }

        public List<List<String>> findSimplePaths(String string, String string2) {
            ArrayList<List<String>> arrayList = new ArrayList<List<String>>();
            HashSet<String> hashSet = new HashSet<String>();
            ArrayList<String> arrayList2 = new ArrayList<String>();
            this.dfs(string, string2, hashSet, arrayList2, arrayList);
            return arrayList;
        }

        private void dfs(String string, String string2, Set<String> set, List<String> list, List<List<String>> list2) {
            set.add(string);
            list.add(string);
            if (string.equals(string2)) {
                list2.add(new ArrayList<String>(list));
            } else {
                for (String string3 : this.adjacencyList.get(string)) {
                    if (set.contains(string3)) continue;
                    this.dfs(string3, string2, set, list, list2);
                }
            }
            set.remove(string);
            list.remove(list.size() - 1);
        }
    }
}
