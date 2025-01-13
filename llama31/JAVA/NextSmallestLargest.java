import java.lang.Integer;
import java.lang.String;
import java.util.TreeSet;

public class NextSmallestLargest {
    private TreeSet<Integer> set;

    public NextSmallestLargest(int[] numbers) {
        set = new TreeSet<>();
        for (int num : numbers) {
            set.add(num);
        }
    }

    public int nextSmallest(int target) {
        return set.floor(target - 1);
    }

    public int nextLargest(int target) {
        return set.ceiling(target + 1);
    }

	public static void main(String[] args) {
	}
}