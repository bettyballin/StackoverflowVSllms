import java.lang.String;
import java.util.Arrays;

public class FindDupsAndMissed {
    public static void main(String[] args) {
        int[] array = {4, 5, 5, 5, 7, 8, 9, 10, 10};
        int[] missed = new int[11];
        int[] duplicates = new int[11];

        int missedIndex = 0;
        int duplicatesIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] - i != 3) {
                missed[missedIndex++] = i + 3;
            }

            if (array[i] - i > 3) {
                duplicates[duplicatesIndex++] = i + 3;
            }
        }

        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Missed: " + Arrays.toString(Arrays.copyOf(missed, missedIndex)));
        System.out.println("Duplicates: " + Arrays.toString(Arrays.copyOf(duplicates, duplicatesIndex)));
    }
}