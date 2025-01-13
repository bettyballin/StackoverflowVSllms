/*
 * Decompiled with CFR 0.152.
 */
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class MessageAuthenticator {
    public static byte[] authenticateMessage(byte[] byArray, byte[] byArray2) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(byArray2, "HmacSHA256");
        mac.init(secretKeySpec);
        return mac.doFinal(byArray);
    }

    public static void main(String[] stringArray) {
    }
}
