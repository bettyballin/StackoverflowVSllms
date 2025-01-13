import java.lang.String;
import java.lang.Integer;
import java.util.Random;

public class SkipList {
    private static final int MAX_LEVEL = 16;
    private static final double P = 0.5;

    private Node head;
    private Random random;

    public SkipList() {
        head = new Node(Integer.MIN_VALUE);
        random = new Random();
    }

    public void insert(int value) {
        Node node = new Node(value);
        Node update[] = new Node[MAX_LEVEL];
        Node current = head;

        for (int i = MAX_LEVEL - 1; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].value < value) {
                current = current.next[i];
            }
            update[i] = current;
        }

        for (int i = 0; i < MAX_LEVEL; i++) {
            if (random.nextDouble() < P) {
                node.next[i] = update[i].next[i];
                update[i].next[i] = node;
            } else {
                break;
            }
        }
    }

    public boolean contains(int value) {
        Node current = head;

        for (int i = MAX_LEVEL - 1; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].value < value) {
                current = current.next[i];
            }
        }

        return current.next[0] != null && current.next[0].value == value;
    }

    private static class Node {
        int value;
        Node[] next;

        Node(int value) {
            this.value = value;
            next = new Node[MAX_LEVEL];
        }
    }

	public static void main(String[] args) {
	}
}