/*
 * Decompiled with CFR 0.152.
 */
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Main_806 {
    public static void main(String[] stringArray) throws Exception {
        String string = "your_encrypted_score";
        String string2 = "your_signature";
        byte[] byArray = "your_private_key_bytes".getBytes();
        String string3 = "your_shared_secret_key";
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(byArray));
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(string3.getBytes(), "HmacSHA256"));
        byte[] byArray2 = mac.doFinal(Base64.getDecoder().decode(string));
        if (!Arrays.equals(byArray2, Base64.getDecoder().decode(string2))) {
            System.out.println("Signature verification failed");
            return;
        }
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(2, privateKey);
        String string4 = new String(cipher.doFinal(Base64.getDecoder().decode(string)));
        System.out.println("Decrypted score: " + string4);
    }
}
