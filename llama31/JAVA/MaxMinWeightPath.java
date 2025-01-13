import java.lang.String;
import java.lang.Integer;
import java.util.*;

public class MaxMinWeightPath {
    public static void findPath(int[][] adjMatrix, int source, int sink) {
        int numVertices = adjMatrix.length;
        int[] distance = new int[numVertices];
        Arrays.fill(distance, Integer.MIN_VALUE);
        distance[source] = Integer.MAX_VALUE;

        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.add(new Vertex(source, distance[source]));

        while (!pq.isEmpty()) {
            Vertex v = pq.poll();
            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[v.id][i] > 0) {
                    int minWeight = Math.min(distance[v.id], adjMatrix[v.id][i]);
                    if (minWeight > distance[i]) {
                        distance[i] = minWeight;
                        pq.add(new Vertex(i, distance[i]));
                    }
                }
            }
        }

        System.out.println("Maximum minimum weight path from " + source + " to " + sink + ": " + distance[sink]);
    }

    private static class Vertex implements Comparable<Vertex> {
        int id;
        int distance;

        public Vertex(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }

        @Override
        public int compareTo(Vertex other) {
            return Integer.compare(other.distance, distance);
        }
    }

    public static void main(String[] args) {
        int[][] adjMatrix = {
                {0, 10, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 10},
                {0, 0, 0, 0}
        };
        findPath(adjMatrix, 0, 3);
    }
}