import java.lang.String;
import java.util.HashSet;

public class MahjongSolver {
    private HashSet<String> visitedStates = new HashSet<>();

    boolean isVisited(String state) {
        return visitedStates.contains(state);
    }

    void markVisited(String state) {
        visitedStates.add(state);
    }

    public static void main(String[] args) {
    }
}