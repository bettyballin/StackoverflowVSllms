import java.lang.String;
public class Example_4 {
    public static void main(String[] args) {
        // O(n) time complexity, but may cause many cache misses
        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        // O(n log n) time complexity, but may have better cache locality
        int[] arr2 = new int[1000000];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i * 2;
        }
    }
}