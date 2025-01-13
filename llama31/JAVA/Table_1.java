import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Table {
    String name;
    List<Table> dependencies;

    public Table(String name) {
        this.name = name;
        this.dependencies = new ArrayList<>();
    }

    public void addDependency(Table table) {
        dependencies.add(table);
    }
}

class DependencyGraph {
    Map<String, Table> tables;

    public DependencyGraph() {
        tables = new HashMap<>();
    }

    public void addTable(String name) {
        tables.put(name, new Table(name));
    }

    public void addDependency(String tableName, String dependencyName) {
        Table table = tables.get(tableName);
        Table dependency = tables.get(dependencyName);
        table.addDependency(dependency);
    }

    public void traverse() {
        // Perform a topological sort on the graph
        // ...
    }
}

public class Table_1_1 {
    public static void main(String[] args) {
        // Example usage
        DependencyGraph graph = new DependencyGraph();
        graph.addTable("A");
        graph.addTable("B");
        graph.addTable("C");
        graph.addDependency("A", "B");
        graph.addDependency("B", "C");
        graph.traverse();
    }
}