import java.lang.String;

public class RandomNumberTester {
    public static void main(String[] args) {
        UniqueRandomGenerator generator = new UniqueRandomGenerator((long) Math.pow(2, 1024) + 1, 48271, 1, System.currentTimeMillis());
        for (int i = 0; i < 10; i++) {
            System.out.println(generator.nextLong());
        }
    }
}

class UniqueRandomGenerator {
    private long modulus;
    private long multiplier;
    private long increment;
    private long seed;

    public UniqueRandomGenerator(long modulus, long multiplier, long increment, long seed) {
        this.modulus = modulus;
        this.multiplier = multiplier;
        this.increment = increment;
        this.seed = seed;
    }

    public long nextLong() {
        seed = (seed * multiplier + increment) % modulus;
        return seed;
    }
}