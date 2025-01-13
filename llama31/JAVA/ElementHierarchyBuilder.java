import java.util.List;
import java.util.ArrayList;

class Element {
    private int id;
    private int parent;

    public int getId() {
        return id;
    }

    public int getParent() {
        return parent;
    }

    public Element(int id, int parent) {
        this.id = id;
        this.parent = parent;
    }
}

public class ElementHierarchyBuilder {
    public List<Element> getChildren(Element current, List<Element> allElements) {
        List<Element> children = new ArrayList<>();
        for (Element element : allElements) {
            if (element.getParent() == current.getId()) {
                children.add(element);
                children.addAll(getChildren(element, allElements));
            }
        }
        return children;
    }

    public static void main(String[] args) {
        // Example usage:
        ElementHierarchyBuilder builder = new ElementHierarchyBuilder();
        List<Element> allElements = new ArrayList<>();
        allElements.add(new Element(1, 0));
        allElements.add(new Element(2, 1));
        allElements.add(new Element(3, 1));
        allElements.add(new Element(4, 2));
        allElements.add(new Element(5, 3));

        Element root = allElements.get(0);
        List<Element> children = builder.getChildren(root, allElements);
        System.out.println("Children of root element:");
        for (Element child : children) {
            System.out.println(child.getId());
        }
    }
}