import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class StackTest_1_1 {
    @Test
    public void testPushAndPop() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    public void testIsEmpty() {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("StackTest_1");
    }
}

class Stack {
    private java.util.ArrayList<Integer> elements = new java.util.ArrayList<>();

    public void push(int element) {
        elements.add(element);
    }

    public int pop() {
        return elements.remove(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}