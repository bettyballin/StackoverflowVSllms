import java.lang.String;

public class ShuffledRangeGenerator_1_1 {
    private long seed;
    private long a;
    private long c;
    private long n;

    public ShuffledRangeGenerator_1(long seed, long n) {
        this.seed = seed;
        this.n = n;
        // Choose suitable LCG parameters
        this.a = 1664525;
        this.c = 1013904223;
    }

    public long next() {
        seed = (a * seed + c) % n;
        return seed;
    }

    public static void main(String[] args) {
        ShuffledRangeGenerator_1 generator = new ShuffledRangeGenerator_1(12345, 1000000);
        for (int i = 0; i < 10; i++) {
            System.out.println(generator.next());
        }
    }
}