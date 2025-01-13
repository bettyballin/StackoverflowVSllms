/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

class BKTree {
    private Node root;

    public BKTree(int[] nArray) {
        this.root = new Node(nArray[0]);
        for (int i = 1; i < nArray.length; ++i) {
            this.insert(nArray[i]);
        }
    }

    private void insert(int n) {
        this.root = this.insertRecursive(this.root, n);
    }

    private Node insertRecursive(Node node, int n) {
        if (node == null) {
            return new Node(n);
        }
        int n2 = this.editDistance(node.key, n);
        if (n2 > 0) {
            node.children[n2] = node.children[n2] == null ? new Node(n) : this.insertRecursive(node.children[n2], n);
        }
        return node;
    }

    public List<int[]> search(int n, int n2) {
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        this.searchRecursive(this.root, n, n2, arrayList);
        return arrayList;
    }

    private void searchRecursive(Node node, int n, int n2, List<int[]> list) {
        if (node == null) {
            return;
        }
        int n3 = this.editDistance(node.key, n);
        if (n3 <= n2) {
            list.add(new int[]{node.key, n3});
        }
        int n4 = Math.max(1, n3 - n2);
        int n5 = Math.min(node.children.length - 1, n3 + n2);
        for (int i = n4; i <= n5; ++i) {
            this.searchRecursive(node.children[i], n, n2, list);
        }
    }

    private int editDistance(int n, int n2) {
        return Math.abs(n - n2);
    }

    private static class Node {
        int key;
        Node[] children;

        public Node(int n) {
            this.key = n;
            this.children = new Node[10];
        }
    }
}
