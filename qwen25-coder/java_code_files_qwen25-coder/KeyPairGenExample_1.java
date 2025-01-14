import java.lang.String;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

public class KeyPairGenExample_1 {
    private static final SecureRandom secureRandom = new SecureRandom();

    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048, secureRandom);
        var keyPair = keyGen.generateKeyPair();
        System.out.println("Generated key pair using shared instance.");
    }
}