import java.util.List;
import java.util.ArrayList;

// Define class A with a name property
class A {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Example {
    public static void main(String[] args) {
        List<A> list = new ArrayList<>();
        A a = new A(); // create a single reusable object

        String[] test = {"ram", "mohan", "anil", "mukesh", "mittal"};

        for (int i = 0; i < test.length; i++) {
            a.setName(test[i]); // reset the object's state
            list.add(a); // add the reusable object to the list
        }

        // Print the list to verify
        for (A item : list) {
            System.out.println(item.getName());
        }
    }
}