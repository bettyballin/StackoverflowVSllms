import java.util.Stack;

public class MinStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        mainStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public int pop() {
        int x = mainStack.pop();
        if (x == minStack.peek()) {
            minStack.pop();
        }
        return x;
    }

    public int getMinimum() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        System.out.println(minStack.getMinimum()); // prints 0
        minStack.pop();
        System.out.println(minStack.getMinimum()); // prints 0
        minStack.pop();
        System.out.println(minStack.getMinimum()); // prints 1
    }
}