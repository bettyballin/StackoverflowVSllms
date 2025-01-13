import java.lang.String;
import javax.xml.bind.DatatypeConverter;

public class Base64Decoder {
    public static String decode(String base64String) {
        byte[] decodedBytes = DatatypeConverter.parseBase64Binary(base64String);
        return new String(decodedBytes);
    }

    public static void main(String[] args) {
        String base64String = "SGVsbG8gd29ybGQh";
        String decodedString = decode(base64String);
        System.out.println(decodedString);
    }
}