/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IntervalTree {
    private Node root;

    public IntervalTree(Collection<Period> collection) {
        this.root = this.buildTree(collection);
    }

    public Collection<Period> getIntersectingPeriods(Period period) {
        ArrayList<Period> arrayList = new ArrayList<Period>();
        this.search(this.root, period, arrayList);
        return arrayList;
    }

    private Node buildTree(Collection<Period> collection) {
        return null;
    }

    private void search(Node node, Period period, List<Period> list) {
        if (node == null) {
            return;
        }
        if (node.interval.intersects(period)) {
            list.add(node.interval);
        }
        if (period.getStart() < node.midpoint) {
            this.search(node.left, period, list);
        }
        if (period.getEnd() > node.midpoint) {
            this.search(node.right, period, list);
        }
    }

    public static void main(String[] stringArray) {
    }

    private static class Node {
        Period interval;
        long midpoint;
        Node left;
        Node right;

        Node(Period period) {
            this.interval = period;
            this.midpoint = (period.getStart() + period.getEnd()) / 2L;
        }
    }
}
