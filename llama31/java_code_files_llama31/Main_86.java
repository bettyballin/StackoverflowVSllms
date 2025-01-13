/*
 * Decompiled with CFR 0.152.
 */
import java.nio.ByteBuffer;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Main_86 {
    public static void main(String[] stringArray) throws Exception {
        String string = "Hello, World!";
        byte[] byArray = new byte[32];
        new SecureRandom().nextBytes(byArray);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(byArray, "AES");
        byte[] byArray2 = new byte[12];
        new SecureRandom().nextBytes(byArray2);
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, byArray2);
        cipher.init(1, (Key)secretKeySpec, gCMParameterSpec);
        byte[] byArray3 = cipher.doFinal(string.getBytes());
        ByteBuffer byteBuffer = ByteBuffer.allocate(byArray2.length + byArray3.length);
        byteBuffer.put(byArray2);
        byteBuffer.put(byArray3);
        byte[] byArray4 = byteBuffer.array();
        System.out.println("Output size: " + byArray4.length);
        System.out.println("Base64-encoded output: " + Base64.getEncoder().encodeToString(byArray4));
    }
}
