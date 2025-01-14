import java.lang.String;
public class Summarizer {
    /**
     * Sums up numbers using Kahan summation algorithm for better accuracy.
     *
     * @param values The values to sum up.
     * @return The sum.
     */
    public static double kahanSum(double... values) {
        double sum = 0.0;
        double c = 0.0; // A running compensation for lost low-order bits.

        for (double value : values) {
            double y = value - c;    // So far, so good: c is zero.
            double t = sum + y;      // Alas, sum is big, y small, so low-order digits of y are lost.
            c = (t - sum) - y;       // (t - sum) recovers the high-order part of y; subtracting y recovers -(low part of y)
            sum = t;                 // Algebraically, c should always be zero. Beware overly-aggressive optimizing compilers!
        }
        return sum;
    }

    public static void main(String[] args) {
        double[] numbers = {1.0, 1e-10, 1e-10, /* ... more small numbers */ };
        System.out.println("Sum: " + kahanSum(numbers));
    }
}