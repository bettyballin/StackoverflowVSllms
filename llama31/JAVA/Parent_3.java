import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Define the nested class structure
class Parent {
    private int id;
    private List<Child> children = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}

class Child {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args) {
        // Simulate a ResultSet for demonstration purposes
        int[] parentIds = {1, 1, 2, 2, 2};
        String[] childValues = {"Child 1-1", "Child 1-2", "Child 2-1", "Child 2-2", "Child 2-3"};

        List<Parent> parents = new ArrayList<>();
        Map<Integer, Parent> parentMap = new HashMap<>();

        for (int i = 0; i < parentIds.length; i++) {
            int parentId = parentIds[i];
            String childValue = childValues[i];

            Parent parent = parentMap.get(parentId);
            if (parent == null) {
                parent = new Parent();
                parent.setId(parentId);
                parentMap.put(parentId, parent);
                parents.add(parent);
            }

            Child child = new Child();
            child.setValue(childValue);
            parent.getChildren().add(child);
        }

        // Print the results
        for (Parent parent : parents) {
            System.out.println("Parent ID: " + parent.getId());
            for (Child child : parent.getChildren()) {
                System.out.println("  Child Value: " + child.getValue());
            }
        }
    }
}