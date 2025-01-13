import java.lang.Integer;
import java.lang.String;
import java.util.TreeMap;

public class AllocationTree {
    private TreeMap<Integer, Allocation> tree;

    public AllocationTree() {
        tree = new TreeMap<>();
    }

    public void addAllocation(int eventId, Allocation allocation) {
        tree.put(eventId, allocation);
    }

    public void removeAllocation(int eventId) {
        tree.remove(eventId);
    }

    public Allocation getAllocation(int eventId) {
        return tree.floorEntry(eventId).getValue();
    }

    public Allocation getStateAfterEvent(int eventId) {
        Allocation allocation = getAllocation(eventId);
        if (allocation != null) {
            // Traverse upwards to find all allocated blocks
            while (allocation.getEventId() < eventId) {
                allocation = tree.higherEntry(allocation.getEventId()).getValue();
            }
            return allocation;
        } else {
            // Traverse downwards to find all deallocated blocks
            Allocation deallocation = tree.lowerEntry(eventId).getValue();
            while (deallocation.getEventId() > eventId) {
                deallocation = tree.lowerEntry(deallocation.getEventId()).getValue();
            }
            return deallocation;
        }
    }
}

class Allocation {
    private int eventId;
    private int allocationId;
    private int size;

    public Allocation(int eventId, int allocationId, int size) {
        this.eventId = eventId;
        this.allocationId = allocationId;
        this.size = size;
    }

    public int getEventId() {
        return eventId;
    }

    public int getAllocationId() {
        return allocationId;
    }

    public int getSize() {
        return size;
    }

	public static void main(String[] args) {
	}
}