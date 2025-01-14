import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ImmutableListCreator_1 {
    List<MyObject> list = new ArrayList<>(); // Initialize the list

    List<MyObject> immutableList = 
           Collections.unmodifiableList(new ArrayList<>(list)); // Shallow copy

    public static void main(String[] args) {
    }
}

class MyObject {
    // Class definition
}