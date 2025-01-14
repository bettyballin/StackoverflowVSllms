import java.lang.String;
import java.util.*;

class SwapRequest {
    int cellA;
    int cellB;
    int priority;

    SwapRequest(int cellA, int cellB, int priority) {
        this.cellA = Math.min(cellA, cellB);
        this.cellB = Math.max(cellA, cellB);
        this.priority = priority;
    }
    
    public int getPriority() {
        return priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SwapRequest)) return false;
        SwapRequest that = (SwapRequest) o;
        return cellA == that.cellA && cellB == that.cellB;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cellA, cellB);
    }
}

public class CellSwapper {
    private PriorityQueue<SwapRequest> requests;

    public CellSwapper() {
        // Initialize with a custom comparator for priority
        this.requests = new PriorityQueue<>(Comparator.comparingInt(SwapRequest::getPriority).reversed());
    }

    public void addRequest(int cellA, int cellB, int priority) {
        SwapRequest request = new SwapRequest(cellA, cellB, priority);
        if (!requests.contains(request)) { // Avoid adding duplicate requests
            requests.add(request);
        }
    }

    public void processRequests() {
        // Process all requests in order of priority
        while (!requests.isEmpty()) {
            SwapRequest request = requests.poll();
            // Perform the actual swap logic here (considering conflicts)
            System.out.println("Swapping cells " + request.cellA + " and " + request.cellB);
            // Implement conflict resolution logic as required
        }
    }

    public static void main(String[] args) {
        CellSwapper swapper = new CellSwapper();
        swapper.addRequest(1, 2, 3);
        swapper.addRequest(2, 3, 5);
        swapper.processRequests();
    }
}