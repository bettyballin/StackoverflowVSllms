import java.lang.String;
import java.math.BigInteger;
import java.util.Comparator;

public class Example_25 implements Comparable<BigInteger> {
    private BigInteger value;

    public Example_25(BigInteger value) {
        this.value = value;
    }

    @Override
    public int compareTo(BigInteger other) {
        return this.value.compareTo(other);
    }

    public static void main(String[] args) {
    }
}