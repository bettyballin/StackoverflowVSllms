/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LayeredTopologicalSort {
    public static List<List<Integer>> layeredTopologicalSort(DirectedGraph directedGraph) {
        List<Integer> list = LayeredTopologicalSort.topologicalSort(directedGraph);
        ArrayList<List<Integer>> arrayList = new ArrayList<List<Integer>>();
        for (Integer n : list) {
            boolean bl = false;
            for (int i = arrayList.size() - 1; i >= 0; --i) {
                List list2 = (List)arrayList.get(i);
                if (!list2.stream().anyMatch(n2 -> directedGraph.hasEdge(n, (int)n2))) continue;
                arrayList.add(i, Collections.singletonList(n));
                bl = true;
                break;
            }
            if (bl) continue;
            arrayList.add(Collections.singletonList(n));
        }
        return arrayList;
    }

    public static List<Integer> topologicalSort(DirectedGraph directedGraph) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        Object object = directedGraph.getVertices().iterator();
        while (object.hasNext()) {
            int n = object.next();
            hashMap.put(n, directedGraph.getInDegree(n));
        }
        object = new LinkedList();
        Iterator iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            int n = (Integer)iterator.next();
            if ((Integer)hashMap.get(n) != 0) continue;
            object.add(n);
        }
        while (!object.isEmpty()) {
            int n = (Integer)object.poll();
            arrayList.add(n);
            for (int n2 : directedGraph.getNeighbors(n)) {
                hashMap.put(n2, (Integer)hashMap.get(n2) - 1);
                if ((Integer)hashMap.get(n2) != 0) continue;
                object.add(n2);
            }
        }
        if (arrayList.size() != directedGraph.getVertices().size()) {
            throw new RuntimeException("Cycle detected in graph");
        }
        return arrayList;
    }

    public static void main(String[] stringArray) {
        DirectedGraph directedGraph = new DirectedGraph();
        directedGraph.addEdge(1, 2);
        directedGraph.addEdge(1, 3);
        directedGraph.addEdge(2, 4);
        directedGraph.addEdge(3, 4);
        List<List<Integer>> list = LayeredTopologicalSort.layeredTopologicalSort(directedGraph);
        System.out.println(list);
    }

    public static class DirectedGraph {
        private Map<Integer, List<Integer>> adjacencyList = new HashMap<Integer, List<Integer>>();
        private Set<Integer> vertices = new HashSet<Integer>();

        public void addEdge(int n2, int n3) {
            this.vertices.add(n2);
            this.vertices.add(n3);
            this.adjacencyList.computeIfAbsent(n2, n -> new ArrayList()).add(n3);
        }

        public boolean hasEdge(int n, int n2) {
            return this.adjacencyList.containsKey(n) && this.adjacencyList.get(n).contains(n2);
        }

        public Set<Integer> getVertices() {
            return this.vertices;
        }

        public List<Integer> getNeighbors(int n) {
            return this.adjacencyList.getOrDefault(n, Collections.emptyList());
        }

        public int getInDegree(int n) {
            int n2 = 0;
            for (List<Integer> list : this.adjacencyList.values()) {
                if (!list.contains(n)) continue;
                ++n2;
            }
            return n2;
        }
    }
}
