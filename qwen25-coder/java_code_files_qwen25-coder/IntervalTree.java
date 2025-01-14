import java.util.ArrayList;
import java.util.Collection;
import java.util.Arrays;
import java.util.Comparator;

public class IntervalTree {

    private final Node root;

    public IntervalTree(Collection<Period> intervals) {
        this.root = build(intervals);
    }

    private Node build(Collection<Period> intervals) {
        // Sort based on start time, mid is the median
        Period[] sortedIntervals = intervals.toArray(new Period[0]);
        Arrays.sort(sortedIntervals, Comparator.comparingLong(Period::getStart));

        return buildRecursive(sortedIntervals, 0, sortedIntervals.length - 1);
    }

    private Node buildRecursive(Period[] periods, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        Node node = new Node(periods[mid]); // Node is the internal structure

        long maxEnd = node.period.getEnd();
        for (int i = start; i <= end; i++) {
            if (periods[i].getEnd() > maxEnd)
                maxEnd = periods[i].getEnd();
        }

        node.maxEnd = maxEnd;

        node.left = buildRecursive(periods, start, mid - 1);
        node.right = buildRecursive(periods, mid + 1, end);

        return node;
    }

    public Collection<Period> getIntersectingPeriods(Period period) {
        Collection<Period> results = new ArrayList<>();
        search(root, period, results);
        return results;
    }

    private void search(Node node, Period period, Collection<Period> result) {
        if (node == null) return;

        if (period.intersects(node.period))
            result.add(node.period);

        if (node.left != null && node.left.maxEnd >= period.getStart())
            search(node.left, period, result);

        if (node.right != null && period.getEnd() > node.period.getStart())
            search(node.right, period, result);
    }

    private static class Node {
        private final Period period;
        private Node left, right;
        private long maxEnd;

        public Node(Period p) {
            this.period = p;
        }
    }

    public static void main(String[] args) {
        // Example usage
        Collection<Period> intervals = new ArrayList<>();
        intervals.add(new Period(1, 5));
        intervals.add(new Period(6, 10));
        intervals.add(new Period(8, 12));
        intervals.add(new Period(15, 20));

        IntervalTree tree = new IntervalTree(intervals);

        Period query = new Period(9, 16);
        Collection<Period> overlapping = tree.getIntersectingPeriods(query);

        System.out.println("Overlapping intervals:");
        for (Period p : overlapping) {
            System.out.println("[" + p.getStart() + ", " + p.getEnd() + "]");
        }
    }
}

class Period {
    private long start;
    private long end;

    public Period(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public long getStart() { return start; }
    public long getEnd() { return end; }

    public boolean intersects(Period other) {
        return this.getStart() < other.getEnd() && other.getStart() < this.getEnd();
    }
}