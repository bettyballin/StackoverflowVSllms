/*
 * Decompiled with CFR 0.152.
 */
public class GraphTester {
    public static void main(String[] stringArray) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        if (graph.isAcyclic()) {
            System.out.println("The graph is acyclic");
        } else {
            System.out.println("The graph contains a cycle");
        }
    }
}
