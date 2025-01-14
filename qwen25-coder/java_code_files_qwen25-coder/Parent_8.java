import java.util.List;

public class Parent_8 {
    @Valid // This triggers validation on each element in the childList
    private List<Child> childList;

    // getters and setters

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }

    public static void main(String[] args) {
    }
}

class Child {
    // Placeholder for Child class
}

@interface Valid {
    // Empty annotation to allow compilation
}