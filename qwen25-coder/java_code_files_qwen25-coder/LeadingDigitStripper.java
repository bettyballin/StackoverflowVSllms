import java.lang.String;
public class LeadingDigitStripper {
    int x = 12345;
    int digits = (int) Math.log10(x) + 1; // Total number of digits in x
    int n = 1; // Number of leading digits to strip
    int result;

    {
        if (n >= digits) {
            result = 0; // If stripping all or more than all digits, result is 0
        } else {
            int power = (int) Math.pow(10, digits - n); // Power of 10 for the remaining part
            result = x % power; // Result: 2345
        }
    }

    public static void main(String[] args) {
    }
}