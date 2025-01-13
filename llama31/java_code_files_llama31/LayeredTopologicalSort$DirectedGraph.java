/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public static class LayeredTopologicalSort.DirectedGraph {
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
