import java.net.URL;

public class HtmlMarkupResourceStreamProvider extends BaseComponent {

    public HtmlMarkupResourceStreamProvider(String id) {
        super(id);
        add(new Label("myLabel", Model.of("Hello")));
    }
    
    @Override
    protected ResourceStream newMarkupResourceStream(IResourceStreamLocator locator, Attributes attributes) {
        URL resource = getClass().getClassLoader().getResource("/MyComponent.html"); // custom location on classpath (e.g., under resources directory).
        return new UrlResourceStream(resource); // return found resource as stream.
    }
    
    public static void main(String[] args) {
        // Entry point of the program
    }
}

// Base class to support super(id) call and add() method
class BaseComponent {
    public BaseComponent(String id) {
        // Constructor implementation
    }
    
    public void add(Label label) {
        // Method implementation
    }
}

// Dummy Label class
class Label {
    public Label(String id, Model model) {
        // Constructor implementation
    }
}

// Dummy Model class with static of() method
class Model {
    public static Model of(String value) {
        return new Model();
    }
}

// Dummy ResourceStream class
class ResourceStream {
    // Class implementation
}

// Dummy UrlResourceStream class extending ResourceStream
class UrlResourceStream extends ResourceStream {
    public UrlResourceStream(URL resource) {
        // Constructor implementation
    }
}

// Dummy IResourceStreamLocator interface
interface IResourceStreamLocator {
    // Interface methods
}

// Dummy Attributes class
class Attributes {
    // Class implementation
}