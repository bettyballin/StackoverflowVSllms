import java.math.BigDecimal;

public class Main_433 {
    public static void main(String[] args) {
        BigDecimal percentMiss;
        double tmp = (double) 600 / 500; // Cast one of the operands to double
        percentMiss = BigDecimal.valueOf(tmp);
        System.out.println(percentMiss.toString() + "-" + tmp);
    }
}