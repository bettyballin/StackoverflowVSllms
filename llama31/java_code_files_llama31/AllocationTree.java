/*
 * Decompiled with CFR 0.152.
 */
import java.util.TreeMap;

public class AllocationTree {
    private TreeMap<Integer, Allocation> tree = new TreeMap();

    public void addAllocation(int n, Allocation allocation) {
        this.tree.put(n, allocation);
    }

    public void removeAllocation(int n) {
        this.tree.remove(n);
    }

    public Allocation getAllocation(int n) {
        return this.tree.floorEntry(n).getValue();
    }

    public Allocation getStateAfterEvent(int n) {
        Allocation allocation = this.getAllocation(n);
        if (allocation != null) {
            while (allocation.getEventId() < n) {
                allocation = this.tree.higherEntry(allocation.getEventId()).getValue();
            }
            return allocation;
        }
        Allocation allocation2 = this.tree.lowerEntry(n).getValue();
        while (allocation2.getEventId() > n) {
            allocation2 = this.tree.lowerEntry(allocation2.getEventId()).getValue();
        }
        return allocation2;
    }
}
