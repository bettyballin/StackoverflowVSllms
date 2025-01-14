import java.lang.String;
import java.lang.Integer;
// Example: Simple CRDT for a counter
import java.util.HashSet;

public class GCounter {
    private HashSet<Integer> incrementSet;
    private int count;

    public GCounter() {
        this.incrementSet = new HashSet<>();
        this.count = 0;
    }

    public void increment(int id) {
        if (!incrementSet.contains(id)) {
            incrementSet.add(id);
            count++;
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
    }
}