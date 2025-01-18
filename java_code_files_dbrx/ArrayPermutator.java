public class ArrayPermutator {
    public void permute(int[] T) {
        for (int i = 0; i < T.length; ++i) {
            int temp = i;
            // Skip condition to avoid swaps or cycles when the same number appears more than once
            if (!((T[temp] >= 0 && T[temp] <= T.length - 1) && (T[i] != T[temp]))) continue;
            swap(T, i, T[temp]); // Swap elements at indices i and T[temp]
        }
    }

    // Method to actually perform the swapping in Java
    public void swap(int[] array, int index1, int index2) {
        // Check whether indices are within valid bounds of the array
        if (index1 >= 0 && index1 < array.length && index2 >= 0 && index2 < array.length) {
            array[index1] = array[index1] ^ array[index2]; // Swap values using 'XOR' operator
            array[index2] = array[index1] ^ array[index2]; // Swaps with previous result
            array[index1] = array[index1] ^ array[index2]; // Final swap
        }
    }
    
    public static void main(String[] args) {
        // You can add code here to test the permute method if needed
    }
}