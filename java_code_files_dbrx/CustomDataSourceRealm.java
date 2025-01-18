import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CustomDataSourceRealm extends DataSourceRealm {
    private String salt;

    public void setSalt(String value) {
        salt = value;
    }

    protected String createDigest(String credentials) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA"); // SHA, MD5 or another strong algorithm can be used here
        } catch (NoSuchAlgorithmException e) {
            return null;
        }

        String saltedCreds = credentials + salt;
        byte[] digestBytes = md.digest(saltedCreds.getBytes());

        StringBuilder sb = new StringBuilder();
        for (byte b : digestBytes) {
            int v = b & 0xff; // & with 0xff to get rid of sign extension in higher bytes
            if (v < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // You can add test code here if needed
    }
}

// Minimal DataSourceRealm class to allow compilation
class DataSourceRealm {
    // Add any methods or fields if required
}