import java.lang.String;
import java.lang.reflect.Method;
import org.junit.Test;

public class StackTest {
    private final Stack stack = new Stack();

    // Public API test cases.
    @Test
    void push_NewEntryIsAddedToTheTop() { /* ... */ }

    @Test
    void pop_LastElementRemovedFromTop() { /* ... */ }

    // Private accessors to support testing internal state.
    Stack[] getStackInternalData() throws Exception {
        Method m = stack.getClass().getDeclaredMethod("getData");
        m.setAccessible(true);
        return (Stack[]) m.invoke(stack);
     }

    public static void main(String[] args) {
    }
}