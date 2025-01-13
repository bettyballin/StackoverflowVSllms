import java.lang.Integer;
import java.lang.String;
import java.util.HashSet;

public class SmallestMissingInteger {
    public static int findSmallestMissingInteger(int[] list) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : list) {
            set.add(i);
        }
        int i = 0;
        while (set.contains(i)) {
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] list = {0, 1, 3, 4, 7};
        System.out.println(findSmallestMissingInteger(list)); // prints 2
    }
}