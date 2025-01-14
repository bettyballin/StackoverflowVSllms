import java.lang.String;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    MyFirstTestClass.class,
    MySecondTestClass.class,
    // Add more test classes as needed
})
public class AllTests {
    // This class remains empty, used only as a holder for the above annotations

    public static void main(String[] args) {
    }
}

class MyFirstTestClass {
}

class MySecondTestClass {
}