import java.lang.String;
import java.util.Arrays;
import java.util.Random;

public class ParallelSortExample {
    public static void main(String[] args) {
        int[] arr = new Random().ints(1000000, 0, 1000000).toArray();
        Arrays.parallelSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}