import java.math.BigDecimal;
import java.math.BigInteger;

public class BigFraction {
    public BigFraction(BigInteger numerator, BigInteger denominator) {
        // canonical constructor
    }

    public BigFraction(BigDecimal d) {
        this(computeNumerator(d), computeDenominator(d));
    }

    private static BigInteger computeNumerator(BigDecimal d) {
        if (d.scale() < 0) {
            return d.unscaledValue().multiply(BigInteger.TEN.pow(-d.scale()));
        } else {
            return d.unscaledValue();
        }
    }

    private static BigInteger computeDenominator(BigDecimal d) {
        if (d.scale() < 0) {
            return BigInteger.ONE;
        } else {
            return BigInteger.TEN.pow(d.scale());
        }
    }

    public static void main(String[] args) {
    }
}