import java.math.BigDecimal;

public class BigDecimalExample {
    // Avoid using this constructor
    BigDecimal bd = new BigDecimal("0.1");

    public static void main(String[] args) {
        BigDecimalExample example = new BigDecimalExample();
        System.out.println(example.bd);
    }
}