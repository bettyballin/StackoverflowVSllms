import java.lang.String;
import java.math.BigInteger;

public class Main_124 {
    public static void main(String[] args) {
        byte[] by = new byte[8];  // the byte array is stored in 'by'
        // populate the byte array
        BigInteger bi = new BigInteger(1, by);
        long numericValue = bi.longValue();
        System.out.println(numericValue);
    }
}