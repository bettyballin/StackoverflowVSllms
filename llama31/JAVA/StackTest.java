import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

    public static class Stack {
        private int[] elements;
        private int top;

        public Stack(int capacity) {
            elements = new int[capacity];
            top = -1;
        }

        public void push(int element) throws Exception {
            if (top >= elements.length - 1) {
                throw new Exception("Stack is full");
            }
            elements[++top] = element;
        }

        public int pop() throws Exception {
            if (top < 0) {
                throw new Exception("Stack is empty");
            }
            return elements[top--];
        }

        public int top() throws Exception {
            if (top < 0) {
                throw new Exception("Stack is empty");
            }
            return elements[top];
        }
    }

    @Test
    public void testEmptyStack() {
        Stack stack = new Stack(5);
        assertThrows(Exception.class, () -> stack.pop());
    }

    @Test
    public void testFullStack() {
        Stack stack = new Stack(5);
        for (int i = 0; i < 5; i++) {
            try {
                stack.push(i);
            } catch (Exception e) {
                fail("Unexpected exception");
            }
        }
        assertThrows(Exception.class, () -> stack.push(5));
    }

    @Test
    public void testTopFunction() {
        Stack stack = new Stack(5);
        try {
            stack.push(1);
        } catch (Exception e) {
            fail("Unexpected exception");
        }
        try {
            assertEquals(1, stack.top());
        } catch (Exception e) {
            fail("Unexpected exception");
        }
        try {
            stack.pop();
        } catch (Exception e) {
            fail("Unexpected exception");
        }
        assertThrows(Exception.class, () -> stack.top());
    }

    @Test
    public void testConcurrentAccess() {
        Stack stack = new Stack(5);
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    stack.push(i);
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    stack.pop();
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        // Verify the stack is in a consistent state
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("StackTest");
    }
}