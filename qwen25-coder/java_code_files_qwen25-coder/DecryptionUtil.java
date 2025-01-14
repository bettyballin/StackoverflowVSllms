import java.lang.String;
public class DecryptionUtil {
    public static void main(String[] args) {
        try {
            String decryptedUniqueIdentifier = QueryStringEncryptor.decrypt(encryptedData);
            System.out.println("Unique Identifier: " + decryptedUniqueIdentifier);
        } catch (QueryStringEncryptor.InvalidDataException e) {
            System.err.println("Invalid or expired token: " + e.getMessage());
        }
    }
}