import java.util.List;
import java.util.stream.Collectors;

// Assume TestA and TestB are classes, where TestB extends TestA
class TestA {}
class TestB extends TestA {}

public class Main_131 {
    public static void main(String[] args) {
        List<TestA> listA = List.of(new TestA(), new TestB(), new TestA(), new TestB()); // assume this is your list of TestA objects

        List<TestB> listB = listA.stream()
                .filter(TestB.class::isInstance)
                .map(TestB.class::cast)
                .collect(Collectors.toList());

        System.out.println(listB);
    }
}