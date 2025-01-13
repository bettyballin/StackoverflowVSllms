/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class ManhattanLayout {
    private List<Node> nodes;
    private List<Edge> edges;

    public ManhattanLayout(List<Node> list, List<Edge> list2) {
        this.nodes = list;
        this.edges = list2;
    }

    public void layout() {
        this.assignLayers();
        this.positionNodes();
        this.routeEdges();
    }

    private void assignLayers() {
        this.nodes.get(0).setLayer(0);
        for (Node node : this.nodes) {
            if (node.getLayer() != -1) continue;
            this.assignLayer(node, 1);
        }
    }

    private void assignLayer(Node node, int n) {
        node.setLayer(n);
        for (Edge edge : this.edges) {
            if (edge.getFrom() != node) continue;
            this.assignLayer(edge.getTo(), n + 1);
        }
    }

    private void positionNodes() {
        for (int i = 0; i <= this.getMaxLayer(); ++i) {
            List<Node> list = this.getLayerNodes(i);
            list.sort((node, node2) -> node.getOrder() - node2.getOrder());
            int n = 0;
            for (Node node3 : list) {
                node3.setPosition(new Point(n, i));
                n += 100;
            }
        }
    }

    private int getMaxLayer() {
        int n = 0;
        for (Node node : this.nodes) {
            n = Math.max(n, node.getLayer());
        }
        return n;
    }

    private List<Node> getLayerNodes(int n) {
        ArrayList<Node> arrayList = new ArrayList<Node>();
        for (Node node : this.nodes) {
            if (node.getLayer() != n) continue;
            arrayList.add(node);
        }
        return arrayList;
    }

    private void routeEdges() {
        for (Edge edge : this.edges) {
            Point point = edge.getFrom().getPosition();
            Point point2 = edge.getTo().getPosition();
            int n = Math.abs(point2.x - point.x) + Math.abs(point2.y - point.y);
            edge.setBendPoints(new ArrayList());
            if (point.x < point2.x) {
                edge.addBendPoint(new Point(point.x + n / 2, point.y));
                edge.addBendPoint(new Point(point2.x - n / 2, point2.y));
                continue;
            }
            edge.addBendPoint(new Point(point.x - n / 2, point.y));
            edge.addBendPoint(new Point(point2.x + n / 2, point2.y));
        }
    }

    public static void main(String[] stringArray) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Edge edge = new Edge(node, node2);
        Edge edge2 = new Edge(node2, node3);
        Edge edge3 = new Edge(node3, node4);
        ArrayList<Node> arrayList = new ArrayList<Node>();
        arrayList.add(node);
        arrayList.add(node2);
        arrayList.add(node3);
        arrayList.add(node4);
        ArrayList<Edge> arrayList2 = new ArrayList<Edge>();
        arrayList2.add(edge);
        arrayList2.add(edge2);
        arrayList2.add(edge3);
        ManhattanLayout manhattanLayout = new ManhattanLayout(arrayList, arrayList2);
        manhattanLayout.layout();
    }
}
