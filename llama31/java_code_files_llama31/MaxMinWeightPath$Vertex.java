/*
 * Decompiled with CFR 0.152.
 */
private static class MaxMinWeightPath.Vertex
implements Comparable<MaxMinWeightPath.Vertex> {
    int id;
    int distance;

    public MaxMinWeightPath.Vertex(int n, int n2) {
        this.id = n;
        this.distance = n2;
    }

    @Override
    public int compareTo(MaxMinWeightPath.Vertex vertex) {
        return Integer.compare(vertex.distance, this.distance);
    }
}
