/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxMinWeightPath {
    public static void findPath(int[][] nArray, int n, int n2) {
        int n3 = nArray.length;
        int[] nArray2 = new int[n3];
        Arrays.fill(nArray2, Integer.MIN_VALUE);
        nArray2[n] = Integer.MAX_VALUE;
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<Vertex>();
        priorityQueue.add(new Vertex(n, nArray2[n]));
        while (!priorityQueue.isEmpty()) {
            Vertex vertex = (Vertex)priorityQueue.poll();
            for (int i = 0; i < n3; ++i) {
                int n4;
                if (nArray[vertex.id][i] <= 0 || (n4 = Math.min(nArray2[vertex.id], nArray[vertex.id][i])) <= nArray2[i]) continue;
                nArray2[i] = n4;
                priorityQueue.add(new Vertex(i, nArray2[i]));
            }
        }
        System.out.println("Maximum minimum weight path from " + n + " to " + n2 + ": " + nArray2[n2]);
    }

    public static void main(String[] stringArray) {
        int[][] nArrayArray = new int[][]{{0, 10, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 10}, {0, 0, 0, 0}};
        MaxMinWeightPath.findPath(nArrayArray, 0, 3);
    }

    private static class Vertex
    implements Comparable<Vertex> {
        int id;
        int distance;

        public Vertex(int n, int n2) {
            this.id = n;
            this.distance = n2;
        }

        @Override
        public int compareTo(Vertex vertex) {
            return Integer.compare(vertex.distance, this.distance);
        }
    }
}
