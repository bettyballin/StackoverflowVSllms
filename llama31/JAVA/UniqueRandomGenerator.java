import java.lang.String;
public class UniqueRandomGenerator {
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
        seed = (multiplier * seed + increment) % modulus;
        return seed;
    }

	public static void main(String[] args) {
	}
}