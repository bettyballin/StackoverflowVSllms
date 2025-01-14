import java.util.*;

class Element {
    int id;
    int parentId;
    String additionalInfo;

    Element(int id, int parentId, String additionalInfo) {
        this.id = id;
        this.parentId = parentId;
        this.additionalInfo = additionalInfo;
    }
}

public class TreeTraversal_2 {

    // Recursive method to find and print all children of a given element ID
    public static void printChildren(List<Element> elements, int parentId) {
        for (Element element : elements) {
            if (element.parentId == parentId) {
                System.out.println("ID: " + element.id + ", Parent ID: " + element.parentId + ", Info: " + element.additionalInfo);
                // Recursively call itself to find children of the current node
                printChildren(elements, element.id);
            }
        }
    }

    public static void main(String[] args) {
        List<Element> elements = new ArrayList<>();
        // Add your elements here
        elements.add(new Element(1, 0, "root element"));
        elements.add(new Element(2, 0, "root element"));
        elements.add(new Element(3, 1, "child element of 1"));
        elements.add(new Element(4, 1, "child element of 1"));
        elements.add(new Element(5, 3, "child element of 3"));

        // Start traversing from the root ID
        int rootId = 1;
        System.out.println("Children of element with ID: " + rootId);
        printChildren(elements, rootId);
    }
}