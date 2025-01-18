import org.junit.runner.Description;
import org.junit.*;
public class TestUtilsClass {
    // This method prevents "No runnable methods" exception when test utility classes are executed by the runner
    @Test
    public void noRunnableMethods() {
        final String name = Description.createTestDescription(getClass(), "noRunnableMethods").getDisplayName();
        Assert.fail("No tests in class: '" + getClass().getName() + "' should execute " + "@Test method, but found: " + name);
    }

    public static void main(String[] args) {
    }
}