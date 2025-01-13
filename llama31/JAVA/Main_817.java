import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.ECGenParameterSpec;
import javax.crypto.Cipher;

public class Main_817 {
    public static void main(String[] args) throws Exception {
        // Generate a key pair for ECC encryption and digital signature
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC");
        ECGenParameterSpec spec = new ECGenParameterSpec("secp256r1");
        kpg.initialize(spec, new SecureRandom());
        KeyPair kp = kpg.generateKeyPair();
        PrivateKey privateKey = kp.getPrivate();
        PublicKey publicKey = kp.getPublic();

        // Encrypt the score data using ECC encryption
        byte[] scoreData = "Score Data".getBytes(); // score data to be encrypted
        Cipher cipher = Cipher.getInstance("ECIES");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedScoreData = cipher.doFinal(scoreData);

        // Sign the encrypted score data using ECDSA digital signature
        Signature sig = Signature.getInstance("SHA256withECDSA");
        sig.initSign(privateKey);
        sig.update(encryptedScoreData);
        byte[] signature = sig.sign();

        // Send the encrypted score data and digital signature to the server
        // ...

        // On the server-side, verify the digital signature and decrypt the score data
        // Verify the digital signature
        Signature sigVerify = Signature.getInstance("SHA256withECDSA");
        sigVerify.initVerify(publicKey);
        sigVerify.update(encryptedScoreData);
        boolean isValid = sigVerify.verify(signature);
        if (isValid) {
            System.out.println("Digital signature is valid");
        } else {
            System.out.println("Digital signature is invalid");
        }

        // Decrypt the score data
        Cipher cipherDecrypt = Cipher.getInstance("ECIES");
        cipherDecrypt.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedScoreData = cipherDecrypt.doFinal(encryptedScoreData);
        System.out.println(new String(decryptedScoreData));
    }
}