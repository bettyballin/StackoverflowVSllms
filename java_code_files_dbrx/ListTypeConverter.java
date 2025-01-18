import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListTypeConverter {
    List<TestA> list = methodReturningList(); // your current list
    List<TestB> newList = list.stream()
        .filter(item -> item instanceof TestB)       // keep only items which are TestB (or subclasses thereof)
        .map(item -> (TestB) item)                // cast to TestB
        .collect(Collectors.toList());             // create new list from stream

    public static void main(String[] args) {
    }

    public List<TestA> methodReturningList() {
        return new ArrayList<TestA>();
    }
}

class TestA {
    // Empty class
}

class TestB extends TestA {
    // Empty class
}