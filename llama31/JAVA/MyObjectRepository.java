import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class MyObjectRepository {
    public Collection<MyObject> getMyObjects() {
        List<MyObject> internalList = new ArrayList<>();
        // populate internalList
        return Collections.unmodifiableList(internalList);
    }

    public static void main(String[] args) {
    }
}

class MyObject {
    // You need to define the MyObject class
}