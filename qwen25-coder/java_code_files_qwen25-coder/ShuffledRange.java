import java.lang.String;
import java.util.stream.IntStream;

public class ShuffledRange {
    private final int n;
    private final long seed;
    private final long a; // multiplier
    private final long c; // increment

    public ShuffledRange(int n, long seed) {
        this.n = n;
        this.seed = seed;
        
        // Example parameters that should work for many n values:
        this.a = 6364136223846793005L; // a good multiplier
        this.c = 192492996048294723L;   // increment should be relatively prime to n if possible
    }

    public IntStream shuffledRange() {
        long[] x = { seed };
        return IntStream.range(0, n).map(i -> {
            x[0] = (a * x[0] + c) % n;
            return (int) x[0];
        });
    }
    
    public static void main(String[] args) {
        ShuffledRange sr = new ShuffledRange(10, System.currentTimeMillis());
        sr.shuffledRange().forEach(System.out::println);
    }
}