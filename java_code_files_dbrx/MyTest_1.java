import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MyTest_1 {
    private OldImplementation oldImplementation = new OldImplementation();
    private NewImplementation newImplementation = new NewImplementation();

    @Test
    void checkBothMethodsReturnSameResult() {
        // Assuming `doSomething` takes no input and returns a String. Adapt as needed for your case.
        assertEquals(oldImplementation.doSomething(), newImplementation.doSomething());
    }

    public static void main(String[] args) {
    }
}