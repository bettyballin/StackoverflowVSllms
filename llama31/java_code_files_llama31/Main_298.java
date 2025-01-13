/*
 * Decompiled with CFR 0.152.
 */
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Main_298 {
    public static void main(String[] stringArray) throws Exception {
        String string = "your_base64_encoded_public_key_here";
        byte[] byArray = Base64.getDecoder().decode(string);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(byArray);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        System.out.println("Public Key: " + String.valueOf(publicKey));
    }
}
