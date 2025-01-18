import java.security.KeyPairGenerator;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class KeyPairGeneratorSample {

    // Declare a single static instance of SecureRandom and synchronize its use across different threads:
    private static final SecureRandom secureRandom = new SecureRandom();
    private static Object syncObject = new Object();  // To handle thread synchronization

    private KeyPair keyPair;

    public synchronized void generateKeyPairs() {
        KeyPairGenerator kpg;
        try {
            kpg = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return;
        }

        synchronized(syncObject) {
            kpg.initialize(2048, secureRandom);
            keyPair = kpg.generateKeyPair();
        }
    }

    public static void main(String[] args) {
        KeyPairGeneratorSample sample = new KeyPairGeneratorSample();
        sample.generateKeyPairs();
        System.out.println("KeyPair generated.");
    }
}