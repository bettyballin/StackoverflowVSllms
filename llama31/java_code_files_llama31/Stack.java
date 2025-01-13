/*
 * Decompiled with CFR 0.152.
 */
import java.util.LinkedList;
import java.util.Queue;

public class Stack {
    private Queue<Integer> q1 = new LinkedList<Integer>();
    private Queue<Integer> q2 = new LinkedList<Integer>();

    public void push(int n) {
        this.q2.add(n);
        while (!this.q1.isEmpty()) {
            this.q2.add(this.q1.poll());
        }
        Queue<Integer> queue = this.q1;
        this.q1 = this.q2;
        this.q2 = queue;
    }

    public int pop() {
        if (this.q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return this.q1.poll();
    }

    public boolean isEmpty() {
        return this.q1.isEmpty();
    }

    public int size() {
        return this.q1.size();
    }

    public static void main(String[] stringArray) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
    }
}
