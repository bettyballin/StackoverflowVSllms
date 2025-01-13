import java.text.Normalizer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class Utf8ToUsAsciiConverter_1_1 {
    public static String convert(String utf8String) {
        // Normalize the input string to NFKD (Compatibility Decomposition)
        String normalized = Normalizer.normalize(utf8String, Normalizer.NFKD);

        // Create a CharsetEncoder for US-ASCII
        CharsetEncoder encoder = Charset.forName("US-ASCII").newEncoder();

        // Convert the normalized string to US-ASCII
        byte[] asciiBytes = normalized.getBytes(Charset.forName("US-ASCII"));

        // Return the converted string
        return new String(asciiBytes, Charset.forName("US-ASCII"));
    }

    public static void main(String[] args) {
        String utf8String = "Åäöü";
        String usAsciiString = convert(utf8String);
        System.out.println(usAsciiString); // prints "Aaou"
    }
}