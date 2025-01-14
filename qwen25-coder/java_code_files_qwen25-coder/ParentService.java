import java.util.ArrayList;
import java.util.List;

public class ParentService {
    public void addChild(Parent parent, Child child) throws Exception {
        if (parent.getChildren().size() >= 2) {
            throw new IllegalArgumentException("A parent can have only up to 2 children");
        }
        parent.addChild(child);
        // Additional logic and database save operations here
    }

    public static void main(String[] args) {
        // Example usage (optional)
        ParentService service = new ParentService();
        Parent parent = new Parent();
        Child child1 = new Child();
        Child child2 = new Child();

        try {
            service.addChild(parent, child1);
            service.addChild(parent, child2);
            // This will throw an exception
            service.addChild(parent, new Child());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class Parent {
    private List<Child> children = new ArrayList<>();

    public List<Child> getChildren() {
        return children;
    }

    public void addChild(Child child) {
        children.add(child);
    }
}

class Child {
    // Additional properties and methods for Child can be added here
}