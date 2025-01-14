import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Optimizer {
    private Map<Integer, Worker> workersById = new HashMap<>();
    private Map<Integer, Shift> shiftsById = new HashMap<>();
    private List<Assignment> assignments;

    public void loadData(List<Worker> workers, List<Shift> shifts, List<Assignment> assignments) {
        for (Worker worker : workers) {
            workersById.put(worker.id, worker);
        }
        for (Shift shift : shifts) {
            shiftsById.put(shift.id, shift);
        }
        this.assignments = assignments;
    }

    public void optimize() {
        // Implement your optimization logic here
        // Use in-memory data structures for quick access and modification
    }

    public void saveChangesToDb() {
        // Logic to update the database with changes made during optimization
    }

    public static void main(String[] args) {
    }

    static class Worker {
        int id;
        // other attributes
    }

    static class Shift {
        int id;
        // other attributes
    }

    static class Assignment {
        int workerId;
        int shiftId;
        // other attributes
    }
}