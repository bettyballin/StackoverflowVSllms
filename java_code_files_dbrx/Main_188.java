// Using more data structures due to 64 bit pointer sizes
public class Main {
    public static void main(String[] args) {
        int[] largeArray1 = new int[1000 * 1000];
        int[] largeArray2 = new int[1000 * 1000];
        largeArray2 = null; // Triggers GC to clear up memory. Will take longer in a 64 bit system.
    }
}