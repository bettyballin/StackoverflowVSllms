import java.lang.String;

public class BubbleSort {
    // Example of a simple polynomial time algorithm: Bubble Sort with complexity O(n^2)
    public void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++)
                if (array[j] > array[j+1]) {
                    // swap temp and array[j]
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
    }
    public static void main(String[] args) {
    }
}