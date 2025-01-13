/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;

public class SignatureVerifier {
    public boolean verifySignature(InputStream inputStream, byte[] byArray, byte[] byArray2) throws Exception {
        int n;
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(byArray2);
        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initVerify(keyFactory.generatePublic(pKCS8EncodedKeySpec));
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] byArray3 = new byte[4096];
        while ((n = bufferedInputStream.read(byArray3)) != -1) {
            signature.update(byArray3, 0, n);
        }
        bufferedInputStream.close();
        return signature.verify(byArray);
    }

    public static void main(String[] stringArray) {
    }
}
