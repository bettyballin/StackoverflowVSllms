import java.lang.String;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class EncodingConverter {
    public static void main(String[] args) {
        // Example Windows-1252 encoded byte array
        byte[] windows1252Bytes = "Your Windows-1252 text here".getBytes(Charset.forName("windows-1252"));

        // Convert to a UTF-16 String
        String utf16String = new String(windows1252Bytes, StandardCharsets.UTF_8);

        // Print the result
        System.out.println(utf16String);
    }
}