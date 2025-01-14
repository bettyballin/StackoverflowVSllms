import java.security.*;
import javax.crypto.*;
import java.security.spec.*;

public class AuthenticationDemo {

    public static void main(String[] args) throws Exception {
        // Server generates its key pair (this would typically already exist)
        KeyPair serverKeyPair = generateKeyPair();

        // Server's public and private keys
        PublicKey serverPublicKey = serverKeyPair.getPublic();
        PrivateKey serverPrivateKey = serverKeyPair.getPrivate();

        // Client generates its key pair (key2)
        KeyPair clientKeyPair = generateKeyPair();

        // Client's public and private keys
        PublicKey clientPublicKey = clientKeyPair.getPublic();
        PrivateKey clientPrivateKey = clientKeyPair.getPrivate();

        // Client encrypts its public key with server's public key and sends it to server
        byte[] encryptedClientPublicKey = encrypt(serverPublicKey, clientPublicKey.getEncoded());
        // Simulate sendToServer
        byte[] receivedEncryptedClientPublicKey = encryptedClientPublicKey;

        // Server decrypts the received message to get client's public key
        byte[] clientPublicKeyBytes = decrypt(serverPrivateKey, receivedEncryptedClientPublicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(clientPublicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey receivedClientPublicKey = keyFactory.generatePublic(keySpec);

        // Server creates a challenge
        String challenge = "someRandomData";

        // Server encrypts the challenge with client's public key
        byte[] encryptedChallenge = encrypt(receivedClientPublicKey, challenge.getBytes());

        // Server signs the encrypted challenge with its private key
        byte[] signature = sign(serverPrivateKey, encryptedChallenge);

        // Server sends encrypted challenge and signature to client
        // Simulate sendToClient
        byte[] receivedEncryptedChallenge = encryptedChallenge;
        byte[] receivedSignature = signature;

        // Client verifies the signature using server's public key
        boolean isValid = verifySignature(serverPublicKey, receivedEncryptedChallenge, receivedSignature);

        if (isValid) {
            // Client decrypts the challenge
            byte[] decryptedChallengeBytes = decrypt(clientPrivateKey, receivedEncryptedChallenge);
            String decryptedChallenge = new String(decryptedChallengeBytes);

            // Client sends back the challenge encrypted with server's public key
            byte[] encryptedResponse = encrypt(serverPublicKey, decryptedChallenge.getBytes());

            // Simulate sendToServer
            byte[] receivedEncryptedResponse = encryptedResponse;

            // Server decrypts the response with its private key
            byte[] decryptedResponseBytes = decrypt(serverPrivateKey, receivedEncryptedResponse);
            String decryptedResponse = new String(decryptedResponseBytes);

            // Server compares the response with the original challenge
            if (challenge.equals(decryptedResponse)) {
                System.out.println("Authentication successful. Server is sure it's talking to a legitimate client.");
            } else {
                System.out.println("Authentication failed. Challenge response does not match.");
            }
        } else {
            System.out.println("Invalid signature. Authentication failed.");
        }
    }

    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048); // You can use 1024 or 4096 as well
        return keyGen.generateKeyPair();
    }

    public static byte[] encrypt(PublicKey key, byte[] plaintext) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(plaintext);
    }

    public static byte[] decrypt(PrivateKey key, byte[] ciphertext) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(ciphertext);
    }

    public static byte[] sign(PrivateKey key, byte[] data) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(key);
        signature.update(data);
        return signature.sign();
    }

    public static boolean verifySignature(PublicKey key, byte[] data, byte[] signatureBytes) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(key);
        signature.update(data);
        return signature.verify(signatureBytes);
    }
}