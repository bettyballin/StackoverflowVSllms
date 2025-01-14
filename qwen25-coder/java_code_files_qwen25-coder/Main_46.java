import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

class ChangeSet {
    private Set<String> changes = new HashSet<>();

    public void add(String change) {
        changes.add(change);
    }

    public void clear() {
        changes.clear();
    }

    public Set<String> getChanges() {
        return changes;
    }
}

class SceneNode {
    private boolean isDirty;
    private ChangeSet changes; // Could be an enum or custom class indicating what changed

    public SceneNode() {
        this.isDirty = false;
        this.changes = new ChangeSet();
    }

    public void applyPhysicsUpdate() {
        // Apply changes to the node
        // ...
        this.isDirty = true;
        this.changes.add("some change");
    }

    public boolean isDirty() {
        return isDirty;
    }

    public ChangeSet getChanges() {
        return changes;
    }

    public void clearFlags() {
        this.isDirty = false;
        changes.clear();
    }
}

class SceneGraph {
    private List<SceneNode> nodes = new ArrayList<>();

    public SceneGraph() {
        // Initialize the nodes list
        nodes.add(new SceneNode());
        // Add more nodes as needed
    }

    public List<SceneNode> getNodes() {
        return nodes;
    }
}

class GraphicsThread {
    private final SceneGraph sceneGraph;

    public GraphicsThread(SceneGraph sceneGraph) {
        this.sceneGraph = sceneGraph;
    }

    // Called periodically to update graphics based on physics changes
    public void update() {
        for (SceneNode node : sceneGraph.getNodes()) {
            if (node.isDirty()) {
                applyGraphicsChanges(node);
                node.clearFlags();
            }
        }
    }

    private void applyGraphicsChanges(SceneNode node) {
        // Apply only the necessary graphical updates based on change set
        ChangeSet changes = node.getChanges();
        // ...
    }
}

class PhysicsThread {
    private final SceneGraph sceneGraph;

    public PhysicsThread(SceneGraph sceneGraph) {
        this.sceneGraph = sceneGraph;
    }

    public void update() {
        for (SceneNode node : sceneGraph.getNodes()) {
            // Simulate physics and mark nodes as dirty
            node.applyPhysicsUpdate();
        }
    }
}

// Optional main class to demonstrate execution
public class Main {
    public static void main(String[] args) {
        SceneGraph sceneGraph = new SceneGraph();
        PhysicsThread physicsThread = new PhysicsThread(sceneGraph);
        GraphicsThread graphicsThread = new GraphicsThread(sceneGraph);

        // Simulate updates
        physicsThread.update();
        graphicsThread.update();
    }
}