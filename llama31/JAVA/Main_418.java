import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main_418_418 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(split(1000000, 100)));
    }

    public static int[] split(long x, int y) {
        List<Integer> multipliers = new ArrayList<>();

        while (x > 0) {
            if (x % y == 0) {
                multipliers.add(y);
                x /= y;
            } else {
                multipliers.add((int) (x % y));
                x /= y;
                break;
            }
        }

        Collections.reverse(multipliers);
        return multipliers.stream().mapToInt(i -> i).toArray();
    }
}