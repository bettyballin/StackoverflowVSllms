/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class GraphConnectedness {
    public static void main(String[] stringArray) {
        Graph graph = new Graph(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        List<List<Edge>> list = graph.findCycles();
        int n = 0;
        for (List<Edge> list2 : list) {
            int n2 = list2.size();
            n += n2 * (n2 - 1) / 2;
        }
        System.out.println("Number of ways to cut 2 edges: " + n);
    }

    private static class Graph {
        int numVertices;
        List<List<Edge>> adjList;

        Graph(int n) {
            this.numVertices = n;
            this.adjList = new ArrayList<List<Edge>>(n);
            for (int i = 0; i < n; ++i) {
                this.adjList.add(new ArrayList());
            }
        }

        void addEdge(int n, int n2) {
            this.adjList.get(n).add(new Edge(n, n2));
            this.adjList.get(n2).add(new Edge(n2, n));
        }

        List<List<Edge>> findCycles() {
            ArrayList<List<Edge>> arrayList = new ArrayList<List<Edge>>();
            boolean[] blArray = new boolean[this.numVertices];
            int[] nArray = new int[this.numVertices];
            for (int i = 0; i < this.numVertices; ++i) {
                if (blArray[i]) continue;
                this.dfs(i, blArray, nArray, arrayList);
            }
            return arrayList;
        }

        private void dfs(int n, boolean[] blArray, int[] nArray, List<List<Edge>> list) {
            blArray[n] = true;
            for (Edge edge : this.adjList.get(n)) {
                int n2 = edge.v;
                if (!blArray[n2]) {
                    nArray[n2] = n;
                    this.dfs(n2, blArray, nArray, list);
                    continue;
                }
                if (nArray[n] == n2) continue;
                ArrayList<Edge> arrayList = new ArrayList<Edge>();
                arrayList.add(edge);
                int n3 = n;
                while (n3 != n2) {
                    int n4 = nArray[n3];
                    arrayList.add(new Edge(n3, n4));
                    n3 = n4;
                }
                list.add(arrayList);
            }
        }
    }

    private static class Edge {
        int u;
        int v;

        Edge(int n, int n2) {
            this.u = n;
            this.v = n2;
        }
    }
}
