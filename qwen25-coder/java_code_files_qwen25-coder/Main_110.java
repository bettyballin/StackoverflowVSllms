import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal bd1 = BigDecimal.valueOf(0.1);
        System.out.println(bd1); // Outputs: 0.1

        BigDecimal bd2 = new BigDecimal("0.1");
        System.out.println(bd2); // Outputs: 0.1
    }
}