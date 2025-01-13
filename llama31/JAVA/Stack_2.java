import java.lang.String;

// Stack implementation using arrays
public class Stack_2_2 {
    private int[] elements;
    private int size;

    public Stack_2(int capacity) {
        elements = new int[capacity];
        size = 0;
    }

    public void push(int element) {
        if (size == elements.length) {
            throw new RuntimeException("Stack is full");
        }
        elements[size++] = element;
    }

    public int pop() {
        if (size == 0) {
            throw new RuntimeException("Stack is empty");
        }
        return elements[--size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        // Example usage
        Stack_2 stack = new Stack_2(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());  // prints 3
        System.out.println(stack.isEmpty());  // prints false
    }
}