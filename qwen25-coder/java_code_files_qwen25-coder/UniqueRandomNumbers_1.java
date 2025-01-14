import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class UniqueRandomNumbers {
    private final Set<Integer> numbers;
    private final Random random;
    private static final int MAX_NUMBER = 1000;

    public UniqueRandomNumbers() {
        this.numbers = new HashSet<>();
        this.random = new Random();
    }

    public Integer next() {
        if (numbers.size() >= MAX_NUMBER + 1) {
            throw new IllegalStateException("All numbers have been generated");
        }
        int randomNumber;
        do {
            randomNumber = random.nextInt(MAX_NUMBER + 1);
        } while (!numbers.add(randomNumber));
        return randomNumber;
    }

    public static void main(String[] args) {
        UniqueRandomNumbers generator = new UniqueRandomNumbers();
        for (int i = 0; i <= MAX_NUMBER; i++) {
            System.out.println(generator.next());
        }
    }
}