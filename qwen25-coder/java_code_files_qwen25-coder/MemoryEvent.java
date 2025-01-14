import java.util.*;

class MemoryEvent {
    int eventId;
    String action; // "ALLOC" or "DEALLOC"
    int uniqueId;

    public MemoryEvent(int eventId, String action, int uniqueId) {
        this.eventId = eventId;
        this.action = action;
        this.uniqueId = uniqueId;
    }
}

class AllocatorState {
    Set<Integer> allocatedIds = new HashSet<>();

    void applyEvent(MemoryEvent event) {
        if ("ALLOC".equals(event.action)) {
            allocatedIds.add(event.uniqueId);
        } else if ("DEALLOC".equals(event.action)) {
            allocatedIds.remove(event.uniqueId);
        }
    }

    AllocatorState deepCopy() {
        AllocatorState copy = new AllocatorState();
        copy.allocatedIds.addAll(this.allocatedIds);
        return copy;
    }
}

public class CheckpointAllocator {
    List<MemoryEvent> events;
    Map<Integer, AllocatorState> checkpoints;
    int checkpointInterval;

    public CheckpointAllocator(List<MemoryEvent> events, int checkpointInterval) {
        this.events = events;
        this.checkpoints = new HashMap<>();
        this.checkpointInterval = checkpointInterval;
        buildCheckpoints();
    }

    private void buildCheckpoints() {
        AllocatorState currentState = new AllocatorState();
        for (int i = 0; i < events.size(); i++) {
            currentState.applyEvent(events.get(i));
            if ((i + 1) % checkpointInterval == 0 || i == events.size() - 1) {
                checkpoints.put(i, currentState.deepCopy());
            }
        }
    }

    AllocatorState getStateAtEvent(int eventIndex) {
        // Find the nearest previous checkpoint
        int prevCheckpoint = (eventIndex / checkpointInterval) * checkpointInterval;
        AllocatorState state = checkpoints.get(prevCheckpoint).deepCopy();

        // Apply events from the checkpoint to the target event index
        for (int i = prevCheckpoint + 1; i <= eventIndex; i++) {
            state.applyEvent(events.get(i));
        }

        return state;
    }

    public static void main(String[] args) {
        List<MemoryEvent> events = new ArrayList<>();

        events.add(new MemoryEvent(0, "ALLOC", 1));
        events.add(new MemoryEvent(1, "ALLOC", 2));
        events.add(new MemoryEvent(2, "DEALLOC", 1));
        // Generate events up to index 9999
        for (int i = 3; i < 9998; i++) {
            String action = (i % 2 == 0) ? "ALLOC" : "DEALLOC";
            int uniqueId = (i % 5) + 1; // Example unique IDs from 1 to 5
            events.add(new MemoryEvent(i, action, uniqueId));
        }
        events.add(new MemoryEvent(9998, "ALLOC", 3));
        events.add(new MemoryEvent(9999, "DEALLOC", 2));

        CheckpointAllocator allocator = new CheckpointAllocator(events, 100);

        AllocatorState stateAt9000 = allocator.getStateAtEvent(9000);
        System.out.println("Allocated IDs at event 9000: " + stateAt9000.allocatedIds);
    }
}