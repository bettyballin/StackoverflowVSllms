import java.util.ArrayList;
import java.util.List;

public class UsabilityChecklist {
    private List<String> heuristics;

    public UsabilityChecklist() {
        heuristics = new ArrayList<>();
        initializeHeuristics();
    }

    private void initializeHeuristics() {
        heuristics.add("Visibility of system status");
        heuristics.add("Match between system and the real world");
        heuristics.add("User control and freedom");
        heuristics.add("Consistency and standards");
        heuristics.add("Error prevention");
        heuristics.add("Recognition rather than recall");
        heuristics.add("Flexibility and efficiency of use");
        heuristics.add("Aesthetic and minimalist design");
        heuristics.add("Help users recognize, diagnose, and recover from errors");
        heuristics.add("Help and documentation");
    }

    public void displayHeuristic(int index) {
        if (index >= 0 && index < heuristics.size()) {
            System.out.println(heuristics.get(index));
        } else {
            System.out.println("Invalid heuristic number.");
        }
    }

    public static void main(String[] args) {
        UsabilityChecklist checklist = new UsabilityChecklist();
        for (int i = 0; i < checklist.heuristics.size(); i++) {
            checklist.displayHeuristic(i);
        }
    }
}