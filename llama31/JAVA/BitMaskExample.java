import java.lang.String;
import java.math.BigInteger;

public class BitMaskExample {
    public static void main(String[] args) {
        BigInteger mask = BigInteger.valueOf(2).pow(128); // 128-bit mask
        BigInteger value = BigInteger.valueOf(2).pow(64); // 64-bit value

        System.out.println(mask.and(value)); // bitwise AND
        System.out.println(mask.or(value)); // bitwise OR
        System.out.println(mask.xor(value)); // bitwise XOR
    }
}