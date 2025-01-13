import java.lang.Integer;
import java.lang.String;

public class BitCounter {
    int countSetBits(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        BitCounter bitCounter = new BitCounter();
        System.out.println(bitCounter.countSetBits(10)); // Example usage
    }
}