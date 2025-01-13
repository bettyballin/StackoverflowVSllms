import java.math.BigDecimal;

public class PriceCalculator {
    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator();
        BigDecimal paPrice = new BigDecimal("90.55");
        BigDecimal result = paPrice.divide(new BigDecimal("1000"));
        System.out.println(result);
    }
}