import java.math.BigDecimal;

public class CurrencyConverter_1_1 {
    public static void main(String[] args) {
        float floatConversionRate = 1.23f; // Example conversion rate
        BigDecimal conversionRate = new BigDecimal(floatConversionRate);
        BigDecimal amount = new BigDecimal("123.4567");
        BigDecimal result = amount.multiply(conversionRate);
        System.out.println(result);
    }
}