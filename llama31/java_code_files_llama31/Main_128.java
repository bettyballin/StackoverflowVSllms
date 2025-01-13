/*
 * Decompiled with CFR 0.152.
 */
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Main_128 {
    public static void main(String[] stringArray) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        LicenseData licenseData = new LicenseData();
        licenseData.setVersion("1.0");
        licenseData.setDuration(365);
        licenseData.setUserName("John Doe");
        SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, secretKey);
        byte[] byArray = cipher.doFinal(licenseData.toByteArray());
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(byArray);
        byte[] byArray2 = signature.sign();
        String string = Base64.getEncoder().encodeToString(byArray2) + "." + Base64.getEncoder().encodeToString(byArray);
        System.out.println(string);
    }
}
