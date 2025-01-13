/*
 * Decompiled with CFR 0.152.
 */
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Encryption {
    public static String encrypt(Properties properties, byte[] byArray) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(byArray);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        Cipher cipher = Cipher.getInstance("RSA/None/OAEPWithSHA1AndMGF1Padding");
        cipher.init(1, publicKey);
        byte[] byArray2 = cipher.doFinal(secretKey.getEncoded());
        Cipher cipher2 = Cipher.getInstance("AES");
        cipher2.init(1, secretKey);
        byte[] byArray3 = properties.toString().getBytes();
        byte[] byArray4 = cipher2.doFinal(byArray3);
        byte[] byArray5 = new byte[byArray2.length + byArray4.length];
        System.arraycopy(byArray2, 0, byArray5, 0, byArray2.length);
        System.arraycopy(byArray4, 0, byArray5, byArray2.length, byArray4.length);
        return Base64.getEncoder().encodeToString(byArray5);
    }

    public static void main(String[] stringArray) {
    }
}
