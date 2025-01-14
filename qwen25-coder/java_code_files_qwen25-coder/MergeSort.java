public class MergeSort {

    public void mergeSort(int[] array) {
        if (array.length < 2) {
            return; // Base case: if the array is of length 0 or 1, it's already sorted.
        }
        
        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];
        
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);
        
        mergeSort(left); // Recursively sort the left half
        mergeSort(right); // Recursively sort the right half
        
        merge(array, left, right); // Merge the sorted halves
    }

    private void merge(int[] result, int[] left, int[] right) {
        int i = 0; // Index into left array
        int j = 0; // Index into right array
        int k = 0; // Index into result array
        
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        
        System.arraycopy(left, i, result, k, left.length - i);
        System.arraycopy(right, j, result, k, right.length - j);
    }

    public static void main(String[] args) {
        MergeSort sorter = new MergeSort();
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        
        System.out.println("Original array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        
        sorter.mergeSort(array);
        
        System.out.println("\nSorted array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}