import java.util.Arrays;

class UniqueExtractor {
    public static int[] extractUniques(int[] array, int N) {
        int[] uniques = new int[N];
        int uniqueIndex = 0;

        outer:
        for (int num : array) {
            for (int i = 0; i < uniqueIndex; i++) {
                if (uniques[i] == num) {
                    continue outer;
                }
            }
            if (uniqueIndex < N) {
                uniques[uniqueIndex++] = num;
            } else {
                break;
            }
        }

        // trim the array if necessary
        if (uniqueIndex < N) {
            int[] trimmedUniques = new int[uniqueIndex];
            System.arraycopy(uniques, 0, trimmedUniques, 0, uniqueIndex);
            return trimmedUniques;
        }

        return uniques;
    }
}

public class Main_321 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 1, 4, 5, 6, 2, 3};
        int N = 5;
        int[] uniques = UniqueExtractor.extractUniques(array, N);
        System.out.println(Arrays.toString(uniques)); // [1, 2, 3, 4, 5]
    }
}