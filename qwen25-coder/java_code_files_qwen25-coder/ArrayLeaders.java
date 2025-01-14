import java.util.ArrayList;
import java.util.List;

public class ArrayLeaders {
    public static List<Integer> findLeaders(int[] arr) {
        List<Integer> leaders = new ArrayList<>();
        if (arr == null || arr.length == 0) return leaders;

        int maxFromRight = arr[arr.length - 1];
        leaders.add(maxFromRight);

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > maxFromRight) {
                leaders.add(0, arr[i]); // Add at the beginning of the list
                maxFromRight = arr[i];
            }
        }

        return leaders;
    }

    public static void main(String[] args) {
        int[] array = {10, 9, 8, 6};
        List<Integer> leaders = findLeaders(array);
        System.out.println(leaders); // Output: [10, 9, 8]
    }
}