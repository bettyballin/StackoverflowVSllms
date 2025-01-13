import java.util.Date;
import java.util.List;

public class IntervalTreeNode {
    private Date start;
    private Date end;
    private List<Object> objects; // Store the objects associated with this interval
    private IntervalTreeNode left;
    private IntervalTreeNode right;

    public IntervalTreeNode(Date start, Date end, List<Object> objects) {
        this.start = start;
        this.end = end;
        this.objects = objects;
        this.left = null;
        this.right = null;
    }

    // Getters and setters

    public static void main(String[] args) {
    }
}