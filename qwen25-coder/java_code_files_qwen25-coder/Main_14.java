import java.math.BigDecimal;
import java.math.RoundingMode;

// Assuming bean.getPaPrice() returns a double or BigDecimal
public class Main {
    public static void main(String[] args) {
        // Create an instance of Bean
        Bean bean = new Bean();

        BigDecimal paPrice = bean.getPaPrice();
        BigDecimal divisor = new BigDecimal(1000);
        BigDecimal result = paPrice.divide(divisor, 5, RoundingMode.HALF_UP);

        // Use the result as needed
        System.out.println("Result: " + result);
    }
}

class Bean {
    public BigDecimal getPaPrice() {
        // Return some example value
        return new BigDecimal("1234.56789");
    }
}