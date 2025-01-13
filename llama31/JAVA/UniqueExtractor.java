import java.util.Arrays;
import java.util.HashSet;

public class UniqueExtractor {
    public static int[] extractUniques(int[] array, int N) {
        HashSet<Integer> uniques = new HashSet<>();
        int[] result = new int[N];
        int index = 0;

        for (int element : array) {
            if (uniques.add(element)) {
                result[index++] = element;
                if (index == N) break;
            }
        }

        return Arrays.copyOf(result, index);
    }

    public static void main(String[] args) {
    }
}