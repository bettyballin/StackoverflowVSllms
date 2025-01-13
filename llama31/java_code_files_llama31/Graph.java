/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Graph {
    private Map<String, List<String>> edges = new HashMap<String, List<String>>();

    Graph() {
    }

    public void addEdge(String string2, String string3) {
        this.edges.computeIfAbsent(string2, string -> new ArrayList()).add(string3);
        this.edges.computeIfAbsent(string3, string -> new ArrayList()).add(string2);
    }

    public List<String> getNeighbors(String string) {
        return this.edges.get(string);
    }
}
