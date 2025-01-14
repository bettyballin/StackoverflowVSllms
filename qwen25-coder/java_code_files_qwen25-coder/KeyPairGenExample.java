import java.lang.String;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

public class KeyPairGenExample {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048, new SecureRandom());
        var keyPair = keyGen.generateKeyPair();
        System.out.println("Generated new key pair.");
    }
}