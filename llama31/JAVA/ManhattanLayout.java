import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class ManhattanLayout {
    private List<Node> nodes;
    private List<Edge> edges;

    public ManhattanLayout(List<Node> nodes, List<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public void layout() {
        // Assign layers to nodes
        assignLayers();

        // Position nodes within layers
        positionNodes();

        // Route edges
        routeEdges();
    }

    private void assignLayers() {
        // Assign the root node to layer 0
        nodes.get(0).setLayer(0);

        // Assign layers to all other nodes
        for (Node node : nodes) {
            if (node.getLayer() == -1) {
                assignLayer(node, 1);
            }
        }
    }

    private void assignLayer(Node node, int layer) {
        node.setLayer(layer);

        for (Edge edge : edges) {
            if (edge.getFrom() == node) {
                assignLayer(edge.getTo(), layer + 1);
            }
        }
    }

    private void positionNodes() {
        // Position nodes within each layer
        for (int layer = 0; layer <= getMaxLayer(); layer++) {
            List<Node> layerNodes = getLayerNodes(layer);

            // Sort nodes within the layer by their order
            layerNodes.sort((n1, n2) -> n1.getOrder() - n2.getOrder());

            // Position nodes within the layer
            int x = 0;
            for (Node node : layerNodes) {
                node.setPosition(new Point(x, layer));
                x += 100; // Node width
            }
        }
    }

    private int getMaxLayer() {
        int maxLayer = 0;
        for (Node node : nodes) {
            maxLayer = Math.max(maxLayer, node.getLayer());
        }
        return maxLayer;
    }

    private List<Node> getLayerNodes(int layer) {
        List<Node> layerNodes = new ArrayList<>();
        for (Node node : nodes) {
            if (node.getLayer() == layer) {
                layerNodes.add(node);
            }
        }
        return layerNodes;
    }

    private void routeEdges() {
        for (Edge edge : edges) {
            // Route the edge between the two nodes
            Point from = edge.getFrom().getPosition();
            Point to = edge.getTo().getPosition();

            // Calculate the Manhattan distance between the two nodes
            int distance = Math.abs(to.x - from.x) + Math.abs(to.y - from.y);

            // Add bend points to the edge
            edge.setBendPoints(new ArrayList<>());
            if (from.x < to.x) {
                edge.addBendPoint(new Point(from.x + distance / 2, from.y));
                edge.addBendPoint(new Point(to.x - distance / 2, to.y));
            } else {
                edge.addBendPoint(new Point(from.x - distance / 2, from.y));
                edge.addBendPoint(new Point(to.x + distance / 2, to.y));
            }
        }
    }

    public static void main(String[] args) {
        // Create nodes
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        // Create edges
        Edge edge1 = new Edge(node1, node2);
        Edge edge2 = new Edge(node2, node3);
        Edge edge3 = new Edge(node3, node4);

        // Create layout
        List<Node> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);

        List<Edge> edges = new ArrayList<>();
        edges.add(edge1);
        edges.add(edge2);
        edges.add(edge3);

        ManhattanLayout layout = new ManhattanLayout(nodes, edges);
        layout.layout();
    }
}

class Node {
    private int layer;
    private Point position;
    private int order;

    public Node(int order) {
        this.order = order;
        this.layer = -1;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public int getOrder() {
        return order;
    }
}

class Edge {
    private Node from;
    private Node to;
    private List<Point> bendPoints;

    public Edge(Node from, Node to) {
        this.from = from;
        this.to = to;
    }

    public Node getFrom() {
        return from;
    }

    public Node getTo() {
        return to;
    }

    public List<Point> getBendPoints() {
        return bendPoints;
    }

    public void setBendPoints(List<Point> bendPoints) {
        this.bendPoints = bendPoints;
    }

    public void addBendPoint(Point bendPoint) {
        this.bendPoints.add(bendPoint);
    }
}