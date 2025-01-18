import java.lang.String;
import java.util.Scanner;

public class ArrayInputReader {
    private static int[] getArrayInput() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // read number of elements the user wants
        int arr[] = new int[n]; // create array with size n
        for (int i = 0; i < n; i++) {
            System.out.print("Enter next element: ");
            arr[i] = sc.nextInt();  //read elements from user
        }
        return arr;
    }
    public static void main(String[] args) {
    }
}