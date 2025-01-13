import java.util.ArrayList;
import java.util.List;

// Assuming an Element class with an id and a parentId for demonstration
class Element {
    int id;
    int parentId;

    public Element(int id, int parentId) {
        this.id = id;
        this.parentId = parentId;
    }

    public int getId() {
        return id;
    }

    public int getParentId() {
        return parentId;
    }
}

public class Main_292 {

    // Method to get children of a given root element from a list of elements
    public static List<Element> getChildren(Element root, List<Element> allElements) {
        List<Element> children = new ArrayList<>();
        for (Element element : allElements) {
            if (element.getParentId() == root.getId()) {
                children.add(element);
            }
        }
        return children;
    }

    public static void main(String[] args) {
        // Example usage
        List<Element> allElements = new ArrayList<>();
        allElements.add(new Element(1, 0)); // Assuming root's parent id as 0
        allElements.add(new Element(2, 1));
        allElements.add(new Element(3, 1));
        allElements.add(new Element(4, 2));
        allElements.add(new Element(5, 3));

        Element root = new Element(1, 0); // The root element

        List<Element> children = getChildren(root, allElements);
        System.out.println("Children of Root (" + root.getId() + "):");
        for (Element child : children) {
            System.out.println("Id: " + child.getId() + ", ParentId: " + child.getParentId());
        }
    }
}