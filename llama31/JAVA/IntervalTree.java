import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

class Period {
    private long start;
    private long end;

    public Period(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    public boolean intersects(Period other) {
        return start <= other.end && end >= other.start;
    }
}

public class IntervalTree {
    private Node root;

    public IntervalTree(Collection<Period> intervals) {
        root = buildTree(intervals);
    }

    public Collection<Period> getIntersectingPeriods(Period p) {
        List<Period> result = new ArrayList<>();
        search(root, p, result);
        return result;
    }

    private Node buildTree(Collection<Period> intervals) {
        // Build the interval tree recursively
        // This method is not implemented in the original code, 
        // so I'm leaving it empty for now.
        return null;
    }

    private void search(Node node, Period p, List<Period> result) {
        if (node == null) return;

        if (node.interval.intersects(p)) {
            result.add(node.interval);
        }

        if (p.getStart() < node.midpoint) {
            search(node.left, p, result);
        }
        if (p.getEnd() > node.midpoint) {
            search(node.right, p, result);
        }
    }

    private static class Node {
        Period interval;
        long midpoint;
        Node left;
        Node right;

        Node(Period interval) {
            this.interval = interval;
            midpoint = (interval.getStart() + interval.getEnd()) / 2;
        }
    }

    public static void main(String[] args) {
    }
}