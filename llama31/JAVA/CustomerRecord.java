import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class CustomerRecord {
    private int version;
    private String hash;
    private String customerData;

    public CustomerRecord(String customerData) {
        this.customerData = customerData;
        this.version = 1;
        this.hash = generateHash(customerData);
    }

    public String generateHash(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(data.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error generating hash: " + e.getMessage());
            return null;
        }
    }

    public String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public void updateRecord(String newCustomerData) {
        this.customerData = newCustomerData;
        this.version++;
        this.hash = generateHash(newCustomerData);
    }

    public static void main(String[] args) {
        CustomerRecord record = new CustomerRecord("John Doe");
        System.out.println("Initial Hash: " + record.hash);
        record.updateRecord("Jane Doe");
        System.out.println("Updated Hash: " + record.hash);
    }
}