import java.lang.String;
public class PriorityQueue {
    private int[] priorities;

    public void insert(int priority, Object element) {
        // Assume priorities is an array of integers
        int index = findIndex(priority);
        // Insert element at index
    }

    private int findIndex(int priority) {
        // Find the index where priority should be inserted
        // Using 0 as highest priority simplifies the comparison
        for (int i = 0; i < priorities.length; i++) {
            if (priority < priorities[i]) {
                return i;
            }
        }
        return priorities.length;
    }

	public static void main(String[] args) {
	}
}