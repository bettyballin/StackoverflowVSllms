// Example of a Java implementation for Fibonacci Heap (just the structure declaration).
public class Node<T extends Comparable<? super T>> {
    public final T value;
    private int degree = 0; // This stores the number of children.
    private boolean mark = false; // This tells if node is in child cut list.
    private Node<T> parent, leftChild, rightSibling, firstChild;

    public Node(T value) {
        this.value = value;
    }
}