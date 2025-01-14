import java.lang.String;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class ImmutableListCreator {
    List<MyObject> list = new ArrayList<>();
    // Populate the list...
    List<MyObject> unmodifiableList = Collections.unmodifiableList(list);

    public static void main(String[] args) {
    }
}

class MyObject {
    // Class definition (can be empty)
}