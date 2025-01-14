import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int item = stack.pop();
            if (item == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        return stack.isEmpty() ? Integer.MIN_VALUE : stack.peek();
    }

    public int getMinimum() {
        return minStack.isEmpty() ? Integer.MIN_VALUE : minStack.peek();
    }

    public static void main(String[] args) {
        // You can add test code here if needed
    }
}