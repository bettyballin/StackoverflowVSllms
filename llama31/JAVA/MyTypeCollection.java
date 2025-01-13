import java.util.List;
import java.util.ArrayList;

public class MyTypeCollection {
    List<MyType> listOfMyType;

    public MyTypeCollection() {
        listOfMyType = new ArrayList<>();
        listOfMyType.add(new MyType()); // assuming MyType has a no-arg constructor
    }

    public static void main(String[] args) {
        new MyTypeCollection();
    }
}

class MyType {} // assuming a simple MyType class