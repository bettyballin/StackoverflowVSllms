/*
 * Decompiled with CFR 0.152.
 */
import java.nio.ByteBuffer;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class NumberEncrypter {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    public static String encrypt(long l, String string) throws Exception {
        byte[] byArray = NumberEncrypter.generateKey(string);
        byte[] byArray2 = NumberEncrypter.generateIV(string);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(1, (Key)new SecretKeySpec(byArray, ALGORITHM), new IvParameterSpec(byArray2));
        byte[] byArray3 = cipher.doFinal(NumberEncrypter.numberToBytes(l));
        return NumberEncrypter.bytesToNumber(byArray3).toString();
    }

    public static String decrypt(String string, String string2) throws Exception {
        byte[] byArray = NumberEncrypter.generateKey(string2);
        byte[] byArray2 = NumberEncrypter.generateIV(string2);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(2, (Key)new SecretKeySpec(byArray, ALGORITHM), new IvParameterSpec(byArray2));
        byte[] byArray3 = cipher.doFinal(NumberEncrypter.numberToBytes(Long.parseLong(string)));
        return NumberEncrypter.bytesToNumber(byArray3).toString();
    }

    private static byte[] generateKey(String string) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        return messageDigest.digest(string.getBytes());
    }

    private static byte[] generateIV(String string) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        return messageDigest.digest(string.getBytes());
    }

    private static byte[] numberToBytes(long l) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        byteBuffer.putLong(l);
        return byteBuffer.array();
    }

    private static Long bytesToNumber(byte[] byArray) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(byArray);
        return byteBuffer.getLong();
    }

    public static void main(String[] stringArray) throws Exception {
        String string = "yourSecurePassword";
        long l = 981762654986L;
        String string2 = NumberEncrypter.encrypt(l, string);
        System.out.println("Encrypted: " + string2);
        String string3 = NumberEncrypter.decrypt(string2, string);
        System.out.println("Decrypted: " + string3);
    }
}
