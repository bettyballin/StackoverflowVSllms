import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        int arr[] = getArrayInput();  // call input method to get user data
        System.out.println("Enter number to search"); // prompt for search number
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(); // read in the search number
        binarySearch(arr, x); // call binary search method with the array and input number as arguments
    }

    static int[] getArrayInput() {
        // Placeholder for getArrayInput method
        return new int[]{};
    }

    static void binarySearch(int[] arr, int x) {
        // Placeholder for binarySearch method
    }
}