import java.lang.String;
// Java example for In-Place Fisher-Yates Shuffle
import java.util.Random;

public class FisherYates {
    static Random rand = new Random();

    public static void shuffle(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            // Swap array[i] with the element at random index
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        shuffle(numbers);
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}