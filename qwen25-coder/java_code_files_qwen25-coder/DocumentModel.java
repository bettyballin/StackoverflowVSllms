import java.lang.String;
import java.util.Observable;
import java.util.Observer;

public interface ModelListener {
    void onChildAdded(Node node);
    void onChildRemoved(Node node);
}

class Node {
    // Stub class for Node
}

enum ModelEventType {
    CHILD_ADDED,
    CHILD_REMOVED
}

class ModelEvent {
    private ModelEventType type;
    private Node node;

    public ModelEvent(ModelEventType type, Node node) {
        this.type = type;
        this.node = node;
    }

    public ModelEventType getType() {
        return type;
    }

    public Node getNode() {
        return node;
    }
}

public class DocumentModel extends Observable {
    public void addChild(Node node) {
        // add logic here for adding a child node
        setChanged();
        notifyObservers(new ModelEvent(ModelEventType.CHILD_ADDED, node));
    }

    public void removeChild(Node node) {
        // add logic here for removing a child node
        setChanged();
        notifyObservers(new ModelEvent(ModelEventType.CHILD_REMOVED, node));
    }
}

public class ViewController implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof ModelEvent) {
            ModelEvent event = (ModelEvent) arg;
            switch(event.getType()) {
                case CHILD_ADDED:
                    // create and attach new MVCNode
                    break;
                case CHILD_REMOVED:
                    // detach and destroy MVCNode
                    break;
            }
        }
    }
}

public class MainClass {
    public static void main(String[] args) {
    }
}