/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileOutputStream;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptedLogger {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    private static final int KEY_SIZE = 256;
    private static final int IV_SIZE = 16;
    private SecretKeySpec key;
    private SecureRandom random;

    public EncryptedLogger(SecretKeySpec secretKeySpec) {
        this.key = secretKeySpec;
        this.random = new SecureRandom();
    }

    public void log(String string) throws Exception {
        byte[] byArray = new byte[16];
        this.random.nextBytes(byArray);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(1, (Key)this.key, new IvParameterSpec(byArray));
        byte[] byArray2 = cipher.doFinal(string.getBytes());
        byte[] byArray3 = new byte[]{(byte)(byArray2.length >> 24), (byte)(byArray2.length >> 16), (byte)(byArray2.length >> 8), (byte)byArray2.length, (byte)(System.currentTimeMillis() >> 56), (byte)(System.currentTimeMillis() >> 48), (byte)(System.currentTimeMillis() >> 40), (byte)(System.currentTimeMillis() >> 32), (byte)(System.currentTimeMillis() >> 24), (byte)(System.currentTimeMillis() >> 16), (byte)(System.currentTimeMillis() >> 8), (byte)System.currentTimeMillis(), (byte)(byArray.length >> 8), (byte)byArray.length, 0, 0};
        FileOutputStream fileOutputStream = new FileOutputStream("log.bin", true);
        fileOutputStream.write(byArray3);
        fileOutputStream.write(byArray);
        fileOutputStream.write(byArray2);
        fileOutputStream.close();
    }

    public static void main(String[] stringArray) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(256);
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyGenerator.generateKey().getEncoded(), ALGORITHM);
        EncryptedLogger encryptedLogger = new EncryptedLogger(secretKeySpec);
        encryptedLogger.log("User 'Bob' logged in");
        encryptedLogger.log("Navigated to config page");
        encryptedLogger.log("Option x changed to y");
    }
}
