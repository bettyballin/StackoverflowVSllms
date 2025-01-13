/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashSet;
import java.util.Set;

public class RangeSet {
    private Node root;

    public Set<Range> intersects(Range range) {
        HashSet<Range> hashSet = new HashSet<Range>();
        this.search(this.root, range, hashSet);
        return hashSet;
    }

    private void search(Node node, Range range, Set<Range> set) {
        if (node == null) {
            return;
        }
        if (node.range.intersects(range)) {
            set.add(node.range);
        }
        if (node.left != null && node.left.max >= range.start) {
            this.search(node.left, range, set);
        }
        if (node.right != null && node.right.min <= range.end) {
            this.search(node.right, range, set);
        }
    }

    public void add(Range range) {
        this.root = this.insert(this.root, range);
    }

    private Node insert(Node node, Range range) {
        if (node == null) {
            return new Node(this, range);
        }
        if (range.start < node.min) {
            node.left = this.insert(node.left, range);
        } else {
            node.right = this.insert(node.right, range);
        }
        node.min = Math.min(node.min, range.start);
        node.max = Math.max(node.max, range.end);
        return node;
    }

    public static void main(String[] stringArray) {
        RangeSet rangeSet = new RangeSet();
        rangeSet.add(new Range(1, 3));
        rangeSet.add(new Range(2, 4));
        rangeSet.add(new Range(5, 7));
        Range range = new Range(2, 6);
        Set<Range> set = rangeSet.intersects(range);
        System.out.println("Intersecting ranges: " + String.valueOf(set));
    }

    private class Node {
        Range range;
        int min;
        int max;
        Node left;
        Node right;

        Node(RangeSet rangeSet, Range range) {
            this.range = range;
            this.min = range.start;
            this.max = range.end;
        }
    }

    private static class Range {
        int start;
        int end;

        Range(int n, int n2) {
            this.start = n;
            this.end = n2;
        }

        boolean intersects(Range range) {
            return this.start <= range.end && range.start <= this.end;
        }
    }
}
