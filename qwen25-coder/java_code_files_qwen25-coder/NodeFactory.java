public class Main {
    public static void main(String[] args) {
        // Example usage
        MVCNode node = NodeFactory.createNode(NodeType.TEXT);
        // Do something with node...
    }
}

enum NodeType {
    TEXT,
    IMAGE
    // add more node types if necessary
}

class NodeFactory {
    public static MVCNode createNode(NodeType type) {
        switch(type) {
            case TEXT:
                return new TextMVCNode();
            case IMAGE:
                return new ImageMVCNode();
            // add more cases if necessary
            default:
                throw new IllegalArgumentException("Unknown node type");
        }
    }
}

abstract class MVCNode {
    protected Model model;
    protected View view;
    protected Controller controller;

    public void setModel(Model model) { /* ... */ }
    public void attachView(View view) { /* ... */ }
    public Controller getController() { return this.controller; }
    // other necessary methods
}

class TextMVCNode extends MVCNode {
    public TextMVCNode() {
        this.model = new TextModel();
        this.view = new TextView();
        this.controller = new TextController(this.model, this.view);
    }
}

class ImageMVCNode extends MVCNode {
    public ImageMVCNode() {
        this.model = new ImageModel();
        this.view = new ImageView();
        this.controller = new ImageController(this.model, this.view);
    }
}

// Placeholder implementations for Model, View, Controller, etc.

class Model {
    // Model properties and methods
}

class View {
    // View properties and methods
}

class Controller {
    protected Model model;
    protected View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    // Controller methods
}

class TextModel extends Model {
    // TextModel-specific properties
}

class TextView extends View {
    // TextView-specific properties
}

class TextController extends Controller {
    public TextController(Model model, View view) {
        super(model, view);
        // TextController-specific initialization
    }
}

class ImageModel extends Model {
    // ImageModel-specific properties
}

class ImageView extends View {
    // ImageView-specific properties
}

class ImageController extends Controller {
    public ImageController(Model model, View view) {
        super(model, view);
        // ImageController-specific initialization
    }
}