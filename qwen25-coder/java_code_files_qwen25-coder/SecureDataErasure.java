import java.lang.String;
public class SecureDataErasure {
    public static void secureWipe(byte[] data) {
        if (data != null) {
            for (int i = 0; i < data.length; i++) {
                data[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        byte[] sensitiveData = "Sensitive information".getBytes();
        // Use the sensitiveData array...
        
        // Securely wipe the sensitiveData
        secureWipe(sensitiveData);
    }
}