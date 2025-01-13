import java.lang.String;

public class ArrayProcessor {
    // Example: Data parallelism
    public void processLargeArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = performOperation(arr[i]);
        }
    }

    public int performOperation(int value) {
        // Add your operation here
        return value; // For now, it just returns the same value
    }

    public static void main(String[] args) {
        ArrayProcessor processor = new ArrayProcessor();
        int[] array = {1, 2, 3, 4, 5};
        processor.processLargeArray(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}