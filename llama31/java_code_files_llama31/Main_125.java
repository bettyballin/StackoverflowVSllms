/*
 * Decompiled with CFR 0.152.
 */
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Main_125 {
    public static void main(String[] stringArray) throws NoSuchAlgorithmException, InvalidKeyException {
        String string = "your_data_here";
        String string2 = "your_secret_key_here";
        SecretKeySpec secretKeySpec = new SecretKeySpec(string2.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKeySpec);
        mac.update(string.getBytes(StandardCharsets.UTF_8));
        byte[] byArray = mac.doFinal();
        StringBuilder stringBuilder = new StringBuilder();
        for (byte by : byArray) {
            String string3 = Integer.toHexString(0xFF & by);
            if (string3.length() == 1) {
                stringBuilder.append('0');
            }
            stringBuilder.append(string3);
        }
        System.out.println(stringBuilder.toString());
    }
}
