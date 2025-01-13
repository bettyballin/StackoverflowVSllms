import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class IntervalTreeSearcher {
    private IntervalTreeNode root;

    public List<Object> findObjectsInRange(Date start, Date end) {
        List<Object> result = new ArrayList<>();
        findObjectsInRangeRecursive(root, start, end, result);
        return result;
    }

    private void findObjectsInRangeRecursive(IntervalTreeNode node, Date start, Date end, List<Object> result) {
        if (node == null) return;

        if (start.compareTo(node.getStart()) <= 0 && end.compareTo(node.getEnd()) >= 0) {
            // The query range completely contains the node's interval
            result.addAll(node.getObjects());
        } else if (start.compareTo(node.getEnd()) < 0 && end.compareTo(node.getStart()) > 0) {
            // The query range overlaps with the node's interval
            findObjectsInRangeRecursive(node.getLeft(), start, end, result);
            findObjectsInRangeRecursive(node.getRight(), start, end, result);
        }
    }

    public static void main(String[] args) {
        // Create an instance of IntervalTreeSearcher to avoid compilation error
        IntervalTreeSearcher searcher = new IntervalTreeSearcher();
    }
}

// Define IntervalTreeNode to avoid compilation error
class IntervalTreeNode {
    private Date start;
    private Date end;
    private List<Object> objects;
    private IntervalTreeNode left;
    private IntervalTreeNode right;

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public List<Object> getObjects() {
        return objects;
    }

    public IntervalTreeNode getLeft() {
        return left;
    }

    public IntervalTreeNode getRight() {
        return right;
    }
}