import java.util.ArrayList;
import java.util.List;

public class Main_31 {
    public static void main(String[] args) {
        List<TestA> listA = getListOfTestA();
        List<TestB> listB = castToTestB(listA);

        // Now listB contains elements of type TestB
    }

    private static List<TestA> getListOfTestA() {
        // This method should return a list of TestA objects where each element is actually an instance of TestB
        List<TestA> testAs = new ArrayList<>();
        testAs.add(new TestB());
        testAs.add(new TestB());
        return testAs;
    }

    private static List<TestB> castToTestB(List<TestA> list) {
        List<TestB> testBs = new ArrayList<>();
        for (TestA item : list) {
            // Check if the item is an instance of TestB
            if (item instanceof TestB) {
                testBs.add((TestB) item);
            } else {
                throw new ClassCastException("Item in list is not an instance of TestB");
            }
        }
        return testBs;
    }
}

class TestA {}
class TestB extends TestA {}