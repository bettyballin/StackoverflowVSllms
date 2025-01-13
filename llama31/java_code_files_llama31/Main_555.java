/*
 * Decompiled with CFR 0.152.
 */
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

public class Main_555 {
    private static final SecureRandom staticRandom = new SecureRandom();

    public static void option1() throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048, secureRandom);
    }

    public static void option2() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048, staticRandom);
    }

    public static void main(String[] stringArray) throws Exception {
        Main_555.option1();
        Main_555.option2();
    }
}
