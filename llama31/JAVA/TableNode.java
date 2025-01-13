import java.util.*;

class TableNode {
    String tableName;
    List<TableNode> neighbors = new ArrayList<>();
    TableNode parent = null;

    public TableNode(String tableName) {
        this.tableName = tableName;
    }

    public void addNeighbor(TableNode neighbor) {
        neighbors.add(neighbor);
    }

    public TableNode getParent() {
        return parent;
    }

    public void setParent(TableNode parent) {
        this.parent = parent;
    }
}

class Graph {
    Map<String, TableNode> nodes = new HashMap<>();

    public void addNode(String tableName) {
        nodes.put(tableName, new TableNode(tableName));
    }

    public void addEdge(String table1, String table2) {
        nodes.get(table1).addNeighbor(nodes.get(table2));
        nodes.get(table2).addNeighbor(nodes.get(table1));
    }

    public List<String> findPath(String startTable, String endTable) {
        // Use a breadth-first search algorithm to find the shortest path
        Queue<TableNode> queue = new LinkedList<>();
        queue.add(nodes.get(startTable));

        Set<TableNode> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            TableNode node = queue.poll();
            if (node.tableName.equals(endTable)) {
                // Reconstruct the path from startTable to endTable
                List<String> path = new ArrayList<>();
                while (node != null) {
                    path.add(node.tableName);
                    node = node.getParent();
                }
                Collections.reverse(path);
                return path;
            }

            for (TableNode neighbor : node.neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    neighbor.setParent(node);
                    queue.add(neighbor);
                }
            }
        }

        return null; // No path found
    }
}

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("Table1");
        graph.addNode("Table2");
        graph.addNode("Table3");
        graph.addEdge("Table1", "Table2");
        graph.addEdge("Table2", "Table3");

        List<String> path = graph.findPath("Table1", "Table3");
        if (path != null) {
            System.out.println("Path found: " + path);
        } else {
            System.out.println("No path found");
        }
    }
}