/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;

public class SecureDataHandler {
    char[] sensitiveData = "secret".toCharArray();

    public SecureDataHandler() {
        Arrays.fill(this.sensitiveData, '0');
    }

    public static void main(String[] stringArray) {
        new SecureDataHandler();
    }
}
