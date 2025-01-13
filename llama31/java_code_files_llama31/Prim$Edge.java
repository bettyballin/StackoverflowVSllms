/*
 * Decompiled with CFR 0.152.
 */
static class Prim.Edge
implements Comparable<Prim.Edge> {
    int v1;
    int v2;
    int weight;

    public Prim.Edge(int n, int n2, int n3) {
        this.v1 = n;
        this.v2 = n2;
        this.weight = n3;
    }

    @Override
    public int compareTo(Prim.Edge edge) {
        return Integer.compare(this.weight, edge.weight);
    }
}
