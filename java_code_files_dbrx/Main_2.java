public class Main {

    private static String bytes2String(byte[] bytes) {
        // Manually convert bytes to hex string
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            // Mask byte with 0xFF to get unsigned value, then format as two-digit hex
            hexString.append(String.format("%02X", b & 0xFF));
        }
        return hexString.toString();
    }

    public static void main(String[] args) {
        // Example usage
        byte[] bytes = { (byte) 0xDE, (byte) 0xAD, (byte) 0xBE, (byte) 0xEF };
        String hexString = bytes2String(bytes);
        System.out.println(hexString); // Output: DEADBEEF
    }
}
```

OR

```java
import java.math.BigInteger;

public class Main {
    private static String bytes2String(byte[] signature) {
        // Convert byte array to a positive BigInteger
        BigInteger bi = new BigInteger(1, signature);
        // Format BigInteger to hex string with leading zeros if necessary
        String hexString = String.format("%0" + (signature.length * 2) + "X", bi);
        return hexString;
    }

    public static void main(String[] args) {
        // Example usage
        byte[] signature = { (byte) 0xDE, (byte) 0xAD, (byte) 0xBE, (byte) 0xEF };
        String hexString = bytes2String(signature);
        System.out.println(hexString); // Output: DEADBEEF
    }
}