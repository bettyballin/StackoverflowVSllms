import java.math.RoundingMode;

public class RoundingCalculator {
    public int round(RoundingMode roundingMode) {
        if (roundingMode == RoundingMode.HALF_UP) {
            // do something
        } else if (roundingMode == RoundingMode.HALF_EVEN) {
            // do something
        }
        // etc
        return 0; // You need to return an integer
    }

    public static void main(String[] args) {
        RoundingCalculator calculator = new RoundingCalculator();
        calculator.round(RoundingMode.HALF_UP);
    }
}