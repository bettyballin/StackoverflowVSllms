import java.util.ArrayList;
import java.util.List;

public class Main_197 {
    public static void main(String[] args) {
        final int SIZE = 1_000_000; // Change this value as needed
        Integer[] array = new Integer[SIZE];
        List<Integer> list = new ArrayList<>(SIZE);

        for (int i = 0; i < SIZE; ++i) {
            array[i] = i;
            list.add(i);
        }

        long start = System.nanoTime();
        int sum_array = 0;
        for (Integer e : array) {
            sum_array += e; // Make use of the elements to avoid compiler optimisation
        }
        double time_taken_by_arrays = (System.nanoTime() - start) / 1e9;

        long start2 = System.nanoTime();
        int sum_list = 0;
        for (Integer e : list) {
            sum_list += e; // Make use of the elements to avoid compiler optimisation
        }
        double time_taken_by_lists = (System.nanoTime() - start2) / 1e9;

        System.out.printf("Arrays took %.4f sec%n", time_taken_by_arrays);
        System.out.printf("Lists took %.4f sec%n", time_taken_by_lists);
    }
}