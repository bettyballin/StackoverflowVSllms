import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListCastingUtil {
    List<TestA> list = methodReturningList(); // your current list
    List<TestB> newList = list.stream()
        .map(item -> (TestB) item)                // cast to TestB
        .collect(Collectors.toList());             // create new list from stream
    
    public static void main(String[] args) {
    }

    List<TestA> methodReturningList() {
        return new ArrayList<TestA>();
    }
}

class TestA {
}

class TestB extends TestA {
}