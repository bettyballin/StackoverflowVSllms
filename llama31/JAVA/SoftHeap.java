import java.lang.String;
import java.util.Arrays;

public class SoftHeap {
    private int[] heap;
    private int size;
    private int errorRate; // controls the trade-off between accuracy and speed

    public SoftHeap(int capacity, int errorRate) {
        heap = new int[capacity];
        size = 0;
        this.errorRate = errorRate;
    }

    public void insert(int value) {
        // insert value into the heap, allowing for some errors
        if (size < heap.length) {
            heap[size++] = value;
        } else {
            // evict the smallest element with a certain probability (errorRate)
            if (Math.random() < errorRate) {
                heap[0] = value;
            }
        }
    }

    public int[] getSortedArray() {
        // return the approximately sorted array
        Arrays.sort(heap, 0, size);
        return Arrays.copyOfRange(heap, 0, size);
    }

	public static void main(String[] args) {
	}
}