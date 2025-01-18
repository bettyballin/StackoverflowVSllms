import java.math.BigDecimal;

public class Main {

    public BigDecimal fromDouble(double value){
        return new BigDecimal(String.valueOf(value)); // this will prevent the rounding issues.
    }

    public static void main(String[] args) {
        // Using fromDouble method
        Main main = new Main();
        BigDecimal bd1 = main.fromDouble(123.456);
        System.out.println("BigDecimal from fromDouble method: " + bd1);

        // Or use the built-in valueOf method
        BigDecimal bd2 = BigDecimal.valueOf(723546); // this also doesn't suffer from inexact values and is more precise than fromDouble method.
        System.out.println("BigDecimal from valueOf method: " + bd2);
    }
}