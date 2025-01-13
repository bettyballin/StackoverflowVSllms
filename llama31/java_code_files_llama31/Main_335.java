/*
 * Decompiled with CFR 0.152.
 */
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Arrays;
import javax.crypto.Cipher;

public class Main_335 {
    public static void main(String[] stringArray) throws Exception {
        String string = "your_alias";
        String string2 = "your_password";
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        cipher.init(1, keyPair.getPublic());
        byte[] byArray = cipher.doFinal(string2.getBytes());
        System.out.println(Arrays.toString(byArray));
    }
}
