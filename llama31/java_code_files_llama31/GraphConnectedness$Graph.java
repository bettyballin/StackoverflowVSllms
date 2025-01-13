/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

private static class GraphConnectedness.Graph {
    int numVertices;
    List<List<GraphConnectedness.Edge>> adjList;

    GraphConnectedness.Graph(int n) {
        this.numVertices = n;
        this.adjList = new ArrayList<List<GraphConnectedness.Edge>>(n);
        for (int i = 0; i < n; ++i) {
            this.adjList.add(new ArrayList());
        }
    }

    void addEdge(int n, int n2) {
        this.adjList.get(n).add(new GraphConnectedness.Edge(n, n2));
        this.adjList.get(n2).add(new GraphConnectedness.Edge(n2, n));
    }

    List<List<GraphConnectedness.Edge>> findCycles() {
        ArrayList<List<GraphConnectedness.Edge>> arrayList = new ArrayList<List<GraphConnectedness.Edge>>();
        boolean[] blArray = new boolean[this.numVertices];
        int[] nArray = new int[this.numVertices];
        for (int i = 0; i < this.numVertices; ++i) {
            if (blArray[i]) continue;
            this.dfs(i, blArray, nArray, arrayList);
        }
        return arrayList;
    }

    private void dfs(int n, boolean[] blArray, int[] nArray, List<List<GraphConnectedness.Edge>> list) {
        blArray[n] = true;
        for (GraphConnectedness.Edge edge : this.adjList.get(n)) {
            int n2 = edge.v;
            if (!blArray[n2]) {
                nArray[n2] = n;
                this.dfs(n2, blArray, nArray, list);
                continue;
            }
            if (nArray[n] == n2) continue;
            ArrayList<GraphConnectedness.Edge> arrayList = new ArrayList<GraphConnectedness.Edge>();
            arrayList.add(edge);
            int n3 = n;
            while (n3 != n2) {
                int n4 = nArray[n3];
                arrayList.add(new GraphConnectedness.Edge(n3, n4));
                n3 = n4;
            }
            list.add(arrayList);
        }
    }
}
