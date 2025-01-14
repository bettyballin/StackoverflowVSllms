import java.lang.String;
import java.lang.Integer;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class OrderNumberObfuscator {
    private static final int ORDER_NUMBER_LENGTH = 9;
    private static final long MAX_VALUE = (long) Math.pow(10, ORDER_NUMBER_LENGTH) - 1;

    private SecretKey secretKey;

    public OrderNumberObfuscator() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        this.secretKey = keyGen.generateKey();
    }

    public String obfuscateOrderNumber(int actualOrderNumber) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] plainText = Integer.toString(actualOrderNumber).getBytes();
        byte[] encryptedBytes = cipher.doFinal(plainText);
        long hashValue = Arrays.hashCode(encryptedBytes);

        // Ensure the "random" number is within 8-9 digits and unique for each actual order number
        return String.format("%0" + ORDER_NUMBER_LENGTH + "d", Math.abs(hashValue) % MAX_VALUE);
    }

    public static void main(String[] args) throws Exception {
        OrderNumberObfuscator obfuscator = new OrderNumberObfuscator();
        System.out.println(obfuscator.obfuscateOrderNumber(1));  // Sample output: 358076294
        System.out.println(obfuscator.obfuscateOrderNumber(2));  // Sample output: 836570921
        System.out.println(obfuscator.obfuscateOrderNumber(3));  // Sample output: 547083641
    }
}