import java.util.LinkedList;
import java.util.Queue;

public class Stack_1_1 {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public Stack_1() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        int result = q1.poll();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return result;
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public int size() {
        return q1.size();
    }

    public static void main(String[] args) {
        Stack_1 stack = new Stack_1();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()); // 3
        System.out.println(stack.pop()); // 2
        System.out.println(stack.pop()); // 1
        System.out.println(stack.isEmpty()); // true
    }
}