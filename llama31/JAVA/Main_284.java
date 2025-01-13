import java.lang.Integer;
import java.lang.String;
public class Main_284 {
    public static void main(String[] args) {
        System.out.println(bitsRequired(11));  // prints 4
    }

    public static int bitsRequired(int n) {
        if (n == 0) return 1;
        return Integer.SIZE - Integer.numberOfLeadingZeros(n);
    }
}