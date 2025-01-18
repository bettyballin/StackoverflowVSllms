public class QuickSortExample {
    public static void quickSort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        } 
        int pivot = array[(highIndex + lowIndex) / 2]; // select random element as a pivot

        int leftPointer = lowIndex; // pointer from the start of sorting area to pivoting item
        int rightPointer = highIndex;

        while (leftPointer <= rightPointer) {
            while (array[leftPointer] < pivot) {
                leftPointer++;
            }
            while (array[rightPointer] > pivot) {
                rightPointer--;
            }
            if (leftPointer <= rightPointer) {
                int temp = array[leftPointer];
                array[leftPointer] = array[rightPointer];
                array[rightPointer] = temp;
                leftPointer++;
                rightPointer--;
            }
        }
        quickSort(array, lowIndex, rightPointer);  // Recursively repeat the process for the two halves.
        quickSort(array, leftPointer, highIndex);
    }
}