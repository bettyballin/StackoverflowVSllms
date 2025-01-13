/*
 * Decompiled with CFR 0.152.
 */
import java.math.BigDecimal;

public class PriceCalculator {
    public static void main(String[] stringArray) {
        PriceCalculator priceCalculator = new PriceCalculator();
        BigDecimal bigDecimal = new BigDecimal("90.55");
        BigDecimal bigDecimal2 = bigDecimal.divide(new BigDecimal("1000"));
        System.out.println(bigDecimal2);
    }
}
