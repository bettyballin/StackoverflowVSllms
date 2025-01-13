import java.security.KeyPairGenerator;
import java.security.SecureRandom;

public class Main_555 {
    // Option 1: Create a new instance every time
    public static void option1() throws Exception {
        SecureRandom random = new SecureRandom();
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048, random);
    }

    // Option 2: Use a static instance
    private static final SecureRandom staticRandom = new SecureRandom();

    public static void option2() throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048, staticRandom);
    }

    public static void main(String[] args) throws Exception {
        option1();
        option2();
    }
}