/*
 * Decompiled with CFR 0.152.
 */
import java.util.Date;
import java.util.List;

class IntervalTreeNode {
    private Date start;
    private Date end;
    private List<Object> objects;
    private IntervalTreeNode left;
    private IntervalTreeNode right;

    IntervalTreeNode() {
    }

    public Date getStart() {
        return this.start;
    }

    public Date getEnd() {
        return this.end;
    }

    public List<Object> getObjects() {
        return this.objects;
    }

    public IntervalTreeNode getLeft() {
        return this.left;
    }

    public IntervalTreeNode getRight() {
        return this.right;
    }
}
