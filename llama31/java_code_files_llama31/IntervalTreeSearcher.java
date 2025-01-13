/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IntervalTreeSearcher {
    private IntervalTreeNode root;

    public List<Object> findObjectsInRange(Date date, Date date2) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        this.findObjectsInRangeRecursive(this.root, date, date2, arrayList);
        return arrayList;
    }

    private void findObjectsInRangeRecursive(IntervalTreeNode intervalTreeNode, Date date, Date date2, List<Object> list) {
        if (intervalTreeNode == null) {
            return;
        }
        if (date.compareTo(intervalTreeNode.getStart()) <= 0 && date2.compareTo(intervalTreeNode.getEnd()) >= 0) {
            list.addAll(intervalTreeNode.getObjects());
        } else if (date.compareTo(intervalTreeNode.getEnd()) < 0 && date2.compareTo(intervalTreeNode.getStart()) > 0) {
            this.findObjectsInRangeRecursive(intervalTreeNode.getLeft(), date, date2, list);
            this.findObjectsInRangeRecursive(intervalTreeNode.getRight(), date, date2, list);
        }
    }

    public static void main(String[] stringArray) {
        IntervalTreeSearcher intervalTreeSearcher = new IntervalTreeSearcher();
    }
}
