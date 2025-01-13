/*
 * Decompiled with CFR 0.152.
 */
import java.util.Stack;

public class MinStack {
    private Stack<Integer> mainStack = new Stack();
    private Stack<Integer> minStack = new Stack();

    public void push(int n) {
        this.mainStack.push(n);
        if (this.minStack.isEmpty() || n <= this.minStack.peek()) {
            this.minStack.push(n);
        }
    }

    public int pop() {
        int n = this.mainStack.pop();
        if (n == this.minStack.peek()) {
            this.minStack.pop();
        }
        return n;
    }

    public int getMinimum() {
        return this.minStack.peek();
    }

    public static void main(String[] stringArray) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        System.out.println(minStack.getMinimum());
        minStack.pop();
        System.out.println(minStack.getMinimum());
        minStack.pop();
        System.out.println(minStack.getMinimum());
    }
}
