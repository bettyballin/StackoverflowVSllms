import java.util.List;
import javax.validation.Valid;

class Child {
    // This is a placeholder for any actual content in the Child class
}

public class Parent {
    @Valid
    private List<Child> childList;

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }

    public static void main(String[] args) {
    }
}