/*
 * Decompiled with CFR 0.152.
 */
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class TokenSigner {
    private static final String HMAC_ALGORITHM = "HmacSHA256";
    private static final byte[] SECRET_KEY = "my_secret_key".getBytes();

    public static String signToken(String string) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(HMAC_ALGORITHM);
        mac.init(new SecretKeySpec(SECRET_KEY, HMAC_ALGORITHM));
        byte[] byArray = mac.doFinal(string.getBytes());
        return TokenSigner.bytesToHex(byArray);
    }

    public static boolean verifyToken(String string, String string2) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(HMAC_ALGORITHM);
        mac.init(new SecretKeySpec(SECRET_KEY, HMAC_ALGORITHM));
        byte[] byArray = mac.doFinal(string.getBytes());
        return TokenSigner.constantTimeEquals(byArray, TokenSigner.hexToBytes(string2));
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

    private static byte[] hexToBytes(String string) {
        int n = string.length();
        byte[] byArray = new byte[n / 2];
        for (int i = 0; i < n; i += 2) {
            byArray[i / 2] = (byte)((Character.digit(string.charAt(i), 16) << 4) + Character.digit(string.charAt(i + 1), 16));
        }
        return byArray;
    }

    private static boolean constantTimeEquals(byte[] byArray, byte[] byArray2) {
        if (byArray.length != byArray2.length) {
            return false;
        }
        int n = 0;
        for (int i = 0; i < byArray.length; ++i) {
            n |= byArray[i] ^ byArray2[i];
        }
        return n == 0;
    }

    public static void main(String[] stringArray) throws NoSuchAlgorithmException, InvalidKeyException {
        String string = "Hello, World!";
        String string2 = TokenSigner.signToken(string);
        System.out.println("Token: " + string);
        System.out.println("Signature: " + string2);
        boolean bl = TokenSigner.verifyToken(string, string2);
        System.out.println("Verified: " + bl);
    }
}
