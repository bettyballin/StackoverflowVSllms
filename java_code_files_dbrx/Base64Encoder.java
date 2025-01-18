import java.lang.String;
import javax.xml.bind.DatatypeConverter;

public class Base64Encoder {
    byte[] encryptedBytes = new byte[0];
    String encryptedQuery = DatatypeConverter.printBase64Binary(encryptedBytes);
    
    public static void main(String[] args) {
    }
}