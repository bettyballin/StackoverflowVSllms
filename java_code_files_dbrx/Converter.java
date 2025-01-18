import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.binary.StringUtils;
import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;

public class Converter {
    public static String convertToASCII(byte[] ebcdicByteArray) throws IOException {
        return new String(ebcdicByteArray, Charset.forName("Cp1047")); // Cp1047 is EBCDIC
    }

    public static byte[] convertToEBCDIC(String asciiText) throws IOException {
        CharsetDetector detector = new CharsetDetector();
        detector.setText(asciiText.getBytes(StandardCharsets.US_ASCII));
        CharsetMatch match = detector.detect(); // detects ASCII
        return new String(StringUtils.getBytesUsAscii(asciiText), StandardCharsets.US_ASCII).getBytes("Cp1047");
    }

    public static void main(String[] args) {
    }
}