class Node {
    int value;
    Node[] next;

    public Node(int value, int level) {
        this.value = value;
        next = new Node[level];
    }
}

public class SkipList {
    private static final double PROBABILITY = 0.5;
    private int maxLevel;
    private Node head;

    public SkipList(int maxLevel) {
        this.maxLevel = maxLevel;
        head = new Node(Integer.MIN_VALUE, maxLevel);
    }

    public void insert(int value) {
        int level = randomLevel();
        Node update[] = new Node[maxLevel];
        Node current = head;

        for (int i = maxLevel - 1; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].value < value) {
                current = current.next[i];
            }
            update[i] = current;
        }

        if (level > maxLevel) {
            for (int i = maxLevel; i < level; i++) {
                update[i] = head;
                maxLevel = level;
            }
        }

        Node newNode = new Node(value, level);
        for (int i = level - 1; i >= 0; i--) {
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }
    }

    private int randomLevel() {
        int lvl = 1;
        while (Math.random() < PROBABILITY && lvl < maxLevel) {
            lvl++;
        }
        return lvl;
    }

    public static void main(String[] args) {
    }
}