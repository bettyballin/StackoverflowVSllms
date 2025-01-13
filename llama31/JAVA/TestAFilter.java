import java.util.List;
import java.util.ArrayList;

public class TestAFilter {
    public static void main(String[] args) {
        List<TestA> listA = new ArrayList<>();
        // populate listA with some data
        
        List<TestB> listB = new ArrayList<>();
        for (TestA a : listA) {
            if (a instanceof TestB) {
                listB.add((TestB) a);
            }
        }
    }
}

class TestA {}
class TestB extends TestA {}