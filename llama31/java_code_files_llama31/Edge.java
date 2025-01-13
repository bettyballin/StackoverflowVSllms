/*
 * Decompiled with CFR 0.152.
 */
class Edge {
    private Node source;
    private Node destination;
    private int weight;

    public Edge(Node node, Node node2, int n) {
        this.source = node;
        this.destination = node2;
        this.weight = n;
    }

    public Node getSource() {
        return this.source;
    }

    public Node getDestination() {
        return this.destination;
    }

    public int getWeight() {
        return this.weight;
    }
}
