/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;

public class DESKeyGenerator {
    String password = "password";
    byte[] key = this.password.getBytes();

    public static void main(String[] stringArray) {
        DESKeyGenerator dESKeyGenerator = new DESKeyGenerator();
        System.out.println("Generated Key: " + Arrays.toString(dESKeyGenerator.key));
    }
}
