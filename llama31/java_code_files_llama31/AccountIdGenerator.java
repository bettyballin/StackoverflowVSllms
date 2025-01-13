/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class AccountIdGenerator {
    private static final String HMAC_ALGORITHM = "HmacSHA256";
    private static final int NEW_ACCOUNT_ID_LENGTH = 16;

    public static String generateNewAccountId(String string, String string2) throws Exception {
        Mac mac = Mac.getInstance(HMAC_ALGORITHM);
        SecretKeySpec secretKeySpec = new SecretKeySpec(string2.getBytes(), HMAC_ALGORITHM);
        mac.init(secretKeySpec);
        byte[] byArray = mac.doFinal(string.getBytes());
        byte[] byArray2 = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(byArray2);
        for (int i = 0; i < 16; ++i) {
            int n = i;
            byArray2[n] = (byte)(byArray2[n] ^ byArray[i % byArray.length]);
        }
        return AccountIdGenerator.bytesToHex(byArray2);
    }

    private static String bytesToHex(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte by : byArray) {
            String string = Integer.toHexString(0xFF & by);
            if (string.length() == 1) {
                stringBuilder.append('0');
            }
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] stringArray) {
    }
}
