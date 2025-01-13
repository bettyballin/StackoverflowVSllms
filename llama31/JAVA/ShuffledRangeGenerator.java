import java.util.Random;

public class ShuffledRangeGenerator {
    private int[] range;
    private int index;

    public ShuffledRangeGenerator(int seed, int size) {
        range = new int[size];
        for (int i = 0; i < size; i++) {
            range[i] = i;
        }
        shuffle(range, new Random(seed));
        index = 0;
    }

    public int next() {
        return range[index++];
    }

    private void shuffle(int[] array, Random random) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }

    public static void main(String[] args) {
        ShuffledRangeGenerator gen = new ShuffledRangeGenerator(42, 1000000);
        for (int i = 0; i < 1000000; i++) {
            System.out.println(gen.next());
        }
    }
}