import java.lang.String;
import java.util.Arrays;
public class BinarySearchAlgorithmorsimplyBinarySearchwouldbeagoodclassnameforthisJavacode {
    private static void binarySearch(int arr[], int x) {
        Arrays.sort(arr); // sort array first before calling binary search
        int l = 0, r = arr.length-1;
        while (l <= r) {
            int m = l + (r - l )/2; // compute mid point using integer division in Java
            if (arr[m] == x){ // check if middle element is equal with search number
                System.out.println("Number found");
                return;
            }
            if (arr[m] < x) { //if the midpoint value smaller than input, we look in right half of array next time
                l = m + 1;
            } else {// if no condition satisfies then we search in left side of subarray.
                r = m - 1;
            }
        }
        System.out.println("Number not found"); // print not found message if loop exits normally
    }
    public static void main(String[] args) {
    }
}