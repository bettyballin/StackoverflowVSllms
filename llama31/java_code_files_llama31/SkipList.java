/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class SkipList {
    private static final int MAX_LEVEL = 16;
    private static final double P = 0.5;
    private Node head = new Node(Integer.MIN_VALUE);
    private Random random = new Random();

    public void insert(int n) {
        int n2;
        Node node = new Node(n);
        Node[] nodeArray = new Node[16];
        Node node2 = this.head;
        for (n2 = 15; n2 >= 0; --n2) {
            while (node2.next[n2] != null && node2.next[n2].value < n) {
                node2 = node2.next[n2];
            }
            nodeArray[n2] = node2;
        }
        for (n2 = 0; n2 < 16 && this.random.nextDouble() < 0.5; ++n2) {
            node.next[n2] = nodeArray[n2].next[n2];
            nodeArray[n2].next[n2] = node;
        }
    }

    public boolean contains(int n) {
        Node node = this.head;
        for (int i = 15; i >= 0; --i) {
            while (node.next[i] != null && node.next[i].value < n) {
                node = node.next[i];
            }
        }
        return node.next[0] != null && node.next[0].value == n;
    }

    public static void main(String[] stringArray) {
    }

    private static class Node {
        int value;
        Node[] next;

        Node(int n) {
            this.value = n;
            this.next = new Node[16];
        }
    }
}
