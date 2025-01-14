import java.math.BigDecimal;
import java.math.BigInteger;

public class BigFraction {

    public BigFraction(BigDecimal d) {
        BigInteger[] result = prepareBigFractionComponents(d);
        this(result[0], result[1]);
    }

    public BigFraction(BigInteger numerator, BigInteger denominator) {
        // Initialize the fraction with numerator and denominator
        // Implementation goes here
    }

    private BigInteger[] prepareBigFractionComponents(BigDecimal d) {
        BigInteger numerator;
        BigInteger denominator;
        if (d.scale() < 0) {
            numerator = d.unscaledValue().multiply(BigInteger.TEN.pow(-d.scale()));
            denominator = BigInteger.ONE;
        } else {
            numerator = d.unscaledValue();
            denominator = BigInteger.TEN.pow(d.scale());
        }
        return new BigInteger[]{numerator, denominator};
    }

    public static void main(String[] args) {
    }
}