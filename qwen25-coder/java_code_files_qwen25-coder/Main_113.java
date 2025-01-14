import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Array example: fixed size
        MyClass[] array = new MyClass[5]; // Fixed to 5 elements

        // List example: dynamic size
        List<MyClass> list = new ArrayList<>();
        list.add(new MyClass()); // Can add as many items as needed
    }
}

class MyClass {
    // Class definition
}