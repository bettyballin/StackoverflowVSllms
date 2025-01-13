/*
 * Decompiled with CFR 0.152.
 */
import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class TokenGenerator {
    private static final String ALGORITHM = "AES/GCM/NoPadding";
    private static final int KEY_SIZE = 128;
    private static final int IV_SIZE = 12;

    public static String generateToken(String string) throws Exception {
        byte[] byArray = new byte[12];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(byArray);
        SecretKeySpec secretKeySpec = new SecretKeySpec(TokenGenerator.getSecretKey(), "AES");
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(1, (Key)secretKeySpec, new GCMParameterSpec(128, byArray));
        byte[] byArray2 = cipher.doFinal((string + ":" + System.currentTimeMillis()).getBytes());
        byte[] byArray3 = new byte[byArray.length + byArray2.length];
        System.arraycopy(byArray, 0, byArray3, 0, byArray.length);
        System.arraycopy(byArray2, 0, byArray3, byArray.length, byArray2.length);
        return Base64.getEncoder().encodeToString(byArray3);
    }

    public static boolean verifyToken(String string, String string2) throws Exception {
        byte[] byArray = Base64.getDecoder().decode(string);
        byte[] byArray2 = new byte[12];
        System.arraycopy(byArray, 0, byArray2, 0, 12);
        byte[] byArray3 = new byte[byArray.length - 12];
        System.arraycopy(byArray, 12, byArray3, 0, byArray.length - 12);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(2, (Key)new SecretKeySpec(TokenGenerator.getSecretKey(), "AES"), new GCMParameterSpec(128, byArray2));
        byte[] byArray4 = cipher.doFinal(byArray3);
        String[] stringArray = new String(byArray4).split(":");
        return stringArray[0].equals(string2);
    }

    private static byte[] getSecretKey() {
        return "your_secret_key_here".getBytes();
    }

    public static void main(String[] stringArray) throws Exception {
        String string = "user123";
        String string2 = TokenGenerator.generateToken(string);
        System.out.println("Generated Token: " + string2);
        boolean bl = TokenGenerator.verifyToken(string2, string);
        System.out.println("Token Verified: " + bl);
    }
}
