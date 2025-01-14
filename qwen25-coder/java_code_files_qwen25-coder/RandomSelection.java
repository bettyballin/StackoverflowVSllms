import java.lang.String;
import java.util.Random;

public class RandomSelection {
    public static void main(String[] args) {
        String[] items = new String[50]; // Assume your array is filled with 50 items
        for (int i = 0; i < items.length; i++) {
            items[i] = "Item" + i; // Example initialization of the array items
        }

        String[] selectedItems = getRandomItems(items, 5);

        for (String item : selectedItems) {
            System.out.println(item);
        }
    }

    public static String[] getRandomItems(String[] items, int count) {
        Random random = new Random();
        String[] result = new String[count];
        boolean[] usedIndexes = new boolean[items.length];

        for (int i = 0; i < count; i++) {
            int index;
            do {
                index = random.nextInt(items.length);
            } while (usedIndexes[index]);
            usedIndexes[index] = true;
            result[i] = items[index];
        }

        return result;
    }
}