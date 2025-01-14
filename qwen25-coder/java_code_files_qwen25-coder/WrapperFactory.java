public class WrapperFactory {
    public static MyWidget wrap(Element element) {
        // Assumes that Element is already obtained, usually by ID.
        assert Document.get().getBody().isOrHasChild(element);
        MyWidget myWidget = new MyWidget();
        myWidget.setElement(element); // Sets the DOM element for this widget
        return myWidget;
    }

    public static MyWidget wrap(String id) {
        final Element elementId = Document.get().getElementById(id);
        if (elementId == null) {
            throw new RuntimeException("Cannot find wrapper for element " + id);
        }
        return wrap(elementId); // Wraps the found element
    }

    public static void main(String[] args) {
        // You can add test code here if needed
    }
}

class MyWidget {
    private Element element;

    public void setElement(Element element) {
        this.element = element;
    }
}

class Element {
    public boolean isOrHasChild(Element element) {
        // Dummy implementation
        return true;
    }
}

class Document {
    private static Document instance = new Document();

    public static Document get() {
        return instance;
    }

    public Element getBody() {
        // Dummy implementation
        return new Element();
    }

    public Element getElementById(String id) {
        // Dummy implementation
        return new Element();
    }
}