import java.lang.String;
import java.lang.Integer;
public class BitCounter {
    public static int countBits(int num) {
        if (num < 0) throw new IllegalArgumentException("Number must be positive.");
        return 32 - Integer.numberOfLeadingZeros(num);
    }

    public static void main(String[] args) {
        int number = 11;
        System.out.println("Number of bits required to represent " + number + ": " + countBits(number));
    }
}