/*
 * Decompiled with CFR 0.152.
 */
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class OracleDESEncryption {
    public static byte[] encrypt(String string, String string2) throws Exception {
        byte[] byArray = string2.getBytes(StandardCharsets.UTF_8);
        byArray = OracleDESEncryption.padKey(byArray, 7);
        Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(byArray, "DES");
        cipher.init(1, secretKeySpec);
        byte[] byArray2 = string.getBytes(StandardCharsets.UTF_8);
        byArray2 = OracleDESEncryption.padInput(byArray2);
        byte[] byArray3 = cipher.doFinal(byArray2);
        return byArray3;
    }

    private static byte[] padKey(byte[] byArray, int n) {
        if (byArray.length < n) {
            byte[] byArray2 = new byte[n];
            System.arraycopy(byArray, 0, byArray2, 0, byArray.length);
            for (int i = byArray.length; i < n; ++i) {
                byArray2[i] = 0;
            }
            return byArray2;
        }
        return byArray;
    }

    private static byte[] padInput(byte[] byArray) {
        int n = 8;
        int n2 = byArray.length % n;
        if (n2 != 0) {
            byte[] byArray2 = new byte[byArray.length + (n - n2)];
            System.arraycopy(byArray, 0, byArray2, 0, byArray.length);
            for (int i = byArray.length; i < byArray2.length; ++i) {
                byArray2[i] = 0;
            }
            return byArray2;
        }
        return byArray;
    }

    public static void main(String[] stringArray) {
    }
}
