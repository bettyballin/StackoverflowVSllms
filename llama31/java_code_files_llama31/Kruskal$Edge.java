/*
 * Decompiled with CFR 0.152.
 */
public static class Kruskal.Edge
implements Comparable<Kruskal.Edge> {
    int u;
    int v;
    int weight;

    public Kruskal.Edge(int n, int n2, int n3) {
        this.u = n;
        this.v = n2;
        this.weight = n3;
    }

    @Override
    public int compareTo(Kruskal.Edge edge) {
        return Integer.compare(this.weight, edge.weight);
    }
}
