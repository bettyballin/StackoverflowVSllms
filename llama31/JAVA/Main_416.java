import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.awssdk.services.kms.model.DecryptRequest;
import software.amazon.awssdk.services.kms.model.DecryptResponse;
import software.amazon.awssdk.services.kms.model.KmsException;

public class Main_416 {
    public static void main(String[] args) {
        KmsClient kmsClient = KmsClient.create();
        byte[] encryptedDbUsername = // assign your encrypted db username byte array here
        byte[] encryptedDbPassword = // assign your encrypted db password byte array here

        try {
            DecryptRequest decryptUsernameRequest = DecryptRequest.builder().ciphertextBlob(encryptedDbUsername).build();
            DecryptRequest decryptPasswordRequest = DecryptRequest.builder().ciphertextBlob(encryptedDbPassword).build();

            DecryptResponse decryptUsernameResponse = kmsClient.decrypt(decryptUsernameRequest);
            DecryptResponse decryptPasswordResponse = kmsClient.decrypt(decryptPasswordRequest);

            String dbUsername = decryptUsernameResponse.plaintext().asStringUtf8();
            String dbPassword = decryptPasswordResponse.plaintext().asStringUtf8();

            System.out.println("Decrypted DB Username: " + dbUsername);
            System.out.println("Decrypted DB Password: " + dbPassword);
        } catch (KmsException e) {
            System.err.println("Failed to decrypt DB credentials: " + e.getMessage());
        }
    }
}