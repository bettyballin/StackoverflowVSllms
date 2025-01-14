import java.util.Stack;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackTest {
    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>();
    }

    @Test
    void testPushAndPop() {
        stack.push(1);
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testIsEmptyWithEmptyStack() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void testIsEmptyAfterPushAndPop() {
        stack.push(2);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    public static void main(String[] args) {
    }
}