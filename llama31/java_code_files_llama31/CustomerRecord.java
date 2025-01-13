/*
 * Decompiled with CFR 0.152.
 */
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CustomerRecord {
    private int version;
    private String hash;
    private String customerData;

    public CustomerRecord(String string) {
        this.customerData = string;
        this.version = 1;
        this.hash = this.generateHash(string);
    }

    public String generateHash(String string) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] byArray = messageDigest.digest(string.getBytes(StandardCharsets.UTF_8));
            return this.bytesToHex(byArray);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            System.err.println("Error generating hash: " + noSuchAlgorithmException.getMessage());
            return null;
        }
    }

    public String bytesToHex(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte by : byArray) {
            String string = Integer.toHexString(0xFF & by);
            if (string.length() == 1) {
                stringBuilder.append('0');
            }
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    public void updateRecord(String string) {
        this.customerData = string;
        ++this.version;
        this.hash = this.generateHash(string);
    }

    public static void main(String[] stringArray) {
        CustomerRecord customerRecord = new CustomerRecord("John Doe");
        System.out.println("Initial Hash: " + customerRecord.hash);
        customerRecord.updateRecord("Jane Doe");
        System.out.println("Updated Hash: " + customerRecord.hash);
    }
}
