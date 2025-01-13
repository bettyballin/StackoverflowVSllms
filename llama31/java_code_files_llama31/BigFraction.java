/*
 * Decompiled with CFR 0.152.
 */
import java.math.BigDecimal;
import java.math.BigInteger;

public class BigFraction {
    public BigFraction(BigInteger bigInteger, BigInteger bigInteger2) {
    }

    public BigFraction(BigDecimal bigDecimal) {
        this(BigFraction.computeNumerator(bigDecimal), BigFraction.computeDenominator(bigDecimal));
    }

    private static BigInteger computeNumerator(BigDecimal bigDecimal) {
        if (bigDecimal.scale() < 0) {
            return bigDecimal.unscaledValue().multiply(BigInteger.TEN.pow(-bigDecimal.scale()));
        }
        return bigDecimal.unscaledValue();
    }

    private static BigInteger computeDenominator(BigDecimal bigDecimal) {
        if (bigDecimal.scale() < 0) {
            return BigInteger.ONE;
        }
        return BigInteger.TEN.pow(bigDecimal.scale());
    }

    public static void main(String[] stringArray) {
    }
}
