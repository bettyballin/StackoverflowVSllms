import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

public class MD5Util {
    public static String getMD5(byte[] data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(data);
        return DatatypeConverter.printHexBinary(hash).toLowerCase();
    }

    public static void main(String[] args) {
    }
}