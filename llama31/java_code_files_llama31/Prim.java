/*
 * Decompiled with CFR 0.152.
 */
import java.util.PriorityQueue;

public class Prim {
    public static void prim(int[][] nArray) {
        int n = nArray.length;
        boolean[] blArray = new boolean[n];
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>();
        for (int i = 1; i < n; ++i) {
            priorityQueue.add(new Edge(0, i, nArray[0][i]));
        }
        while (!priorityQueue.isEmpty()) {
            Edge edge = (Edge)priorityQueue.poll();
            if (blArray[edge.v2]) continue;
            blArray[edge.v2] = true;
            System.out.println("Added edge: " + edge.v1 + " - " + edge.v2 + " with weight " + edge.weight);
            for (int i = 0; i < n; ++i) {
                if (blArray[i] || nArray[edge.v2][i] == 0) continue;
                priorityQueue.add(new Edge(edge.v2, i, nArray[edge.v2][i]));
            }
        }
    }

    public static void main(String[] stringArray) {
        int[][] nArrayArray = new int[][]{{0, 2, 0, 6, 0}, {2, 0, 3, 8, 5}, {0, 3, 0, 0, 7}, {6, 8, 0, 0, 9}, {0, 5, 7, 9, 0}};
        Prim.prim(nArrayArray);
    }

    static class Edge
    implements Comparable<Edge> {
        int v1;
        int v2;
        int weight;

        public Edge(int n, int n2, int n3) {
            this.v1 = n;
            this.v2 = n2;
            this.weight = n3;
        }

        @Override
        public int compareTo(Edge edge) {
            return Integer.compare(this.weight, edge.weight);
        }
    }
}
