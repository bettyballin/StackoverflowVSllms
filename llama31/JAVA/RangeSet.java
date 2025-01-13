import java.util.HashSet;
import java.util.Set;

public class RangeSet {
    private Node root;

    public Set<Range> intersects(Range range) {
        Set<Range> result = new HashSet<>();
        search(root, range, result);
        return result;
    }

    private void search(Node node, Range range, Set<Range> result) {
        if (node == null) return;

        if (node.range.intersects(range)) {
            result.add(node.range);
        }

        if (node.left != null && node.left.max >= range.start) {
            search(node.left, range, result);
        }

        if (node.right != null && node.right.min <= range.end) {
            search(node.right, range, result);
        }
    }

    public void add(Range range) {
        root = insert(root, range);
    }

    private Node insert(Node node, Range range) {
        if (node == null) {
            return new Node(range);
        }

        if (range.start < node.min) {
            node.left = insert(node.left, range);
        } else {
            node.right = insert(node.right, range);
        }

        node.min = Math.min(node.min, range.start);
        node.max = Math.max(node.max, range.end);

        return node;
    }

    private class Node {
        Range range;
        int min, max;
        Node left, right;

        Node(Range range) {
            this.range = range;
            min = range.start;
            max = range.end;
        }
    }

    private static class Range {
        int start, end;

        Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean intersects(Range other) {
            return start <= other.end && other.start <= end;
        }
    }

    public static void main(String[] args) {
        RangeSet rangeSet = new RangeSet();
        rangeSet.add(new Range(1, 3));
        rangeSet.add(new Range(2, 4));
        rangeSet.add(new Range(5, 7));

        Range queryRange = new Range(2, 6);
        Set<Range> result = rangeSet.intersects(queryRange);
        System.out.println("Intersecting ranges: " + result);
    }
}