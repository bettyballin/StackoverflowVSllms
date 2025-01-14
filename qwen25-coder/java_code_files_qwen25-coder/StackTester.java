import java.util.EmptyStackException;
import java.util.Stack;

public class StackTester {
    public static void main(String[] args) {
        int size = 5;
        Stack<Integer> stack = new Stack<>();

        // Test 1: Pop from empty stack
        try {
            Integer x = stack.pop();
            System.out.println("Popped from empty stack: " + x); // Should throw EmptyStackException
        } catch (EmptyStackException e) {
            System.out.println("Caught expected EmptyStackException");
        }

        // Test 2: Push n+1 elements
        try {
            for (int i = 0; i <= size; i++) { // Loop till n+1
                stack.push(i);
                System.out.println("Pushed " + i);
            }
        } catch (StackOverflowError e) { // Use StackOverflowError if size is fixed and exceeds
            System.out.println("Caught expected StackOverflowError");
        }

        // Test 3: Validate empty, full, top functions
        System.out.println("Stack is empty: " + stack.isEmpty());
        System.out.println("Stack is full (size=" + stack.size() + "): " + (stack.size() == size));
        System.out.println("Top element: " + stack.peek());

        // Test 5: Basic functionality
        int x = 10;
        stack.push(x);
        System.out.println("Pushed " + x);
        Integer y = stack.pop();
        System.out.println("Popped " + y);

        // Test 4: Multithreaded environment would be more complex and involve concurrent access tests.
    }
}