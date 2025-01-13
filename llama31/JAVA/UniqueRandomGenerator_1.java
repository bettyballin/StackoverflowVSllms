import java.util.Random;

public class UniqueRandomGenerator_1 {
    private int[] numbers;
    private int index;
    private Random random;

    public UniqueRandomGenerator(int max) {
        numbers = new int[max];
        for (int i = 0; i < max; i++) {
            numbers[i] = i;
        }
        index = max - 1;
        random = new Random();
    }

    public int next() {
        if (index < 0) {
            throw new RuntimeException("No more unique numbers available");
        }
        int randomIndex = random.nextInt(index + 1);
        int result = numbers[randomIndex];
        numbers[randomIndex] = numbers[index];
        numbers[index] = result;
        index--;
        return result;
    }

    public static void main(String[] args) {
        UniqueRandomGenerator generator = new UniqueRandomGenerator(10);
        for (int i = 0; i < 10; i++) {
            System.out.println(generator.next());
        }
    }
}