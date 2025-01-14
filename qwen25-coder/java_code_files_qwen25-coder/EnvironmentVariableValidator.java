public class EnvironmentVariableValidator {
    String encryptionKey = System.getenv("ENCRYPTION_KEY");
    String initVector = System.getenv("INIT_VECTOR");
    
    {
        if (encryptionKey == null || initVector == null) {
            throw new RuntimeException("Encryption key or initialization vector not set in environment variables.");
        }
    }
    
    public static void main(String[] args) {
    }
}