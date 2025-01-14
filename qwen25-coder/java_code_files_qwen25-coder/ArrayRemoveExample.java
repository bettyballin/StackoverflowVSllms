import java.lang.String;
import java.util.Arrays;

public class ArrayRemoveExample {
    public static int[] removeElement(int[] originalArray, int elementToRemove) {
        // Find the index of the element to remove
        int index = Arrays.binarySearch(originalArray, elementToRemove);
        
        // If the element is not found, return the original array or handle as needed
        if (index < 0) {
            return originalArray;
        }

        // Create a new array of size one less than the original array
        int[] newArray = new int[originalArray.length - 1];

        // Copy elements from the original array to the new array, excluding the element to remove
        System.arraycopy(originalArray, 0, newArray, 0, index);
        System.arraycopy(originalArray, index + 1, newArray, index, originalArray.length - index - 1);

        return newArray;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int[] newArray = removeElement(array, 3);
        System.out.println(Arrays.toString(newArray)); // Output: [1, 2, 4, 5]
    }
}