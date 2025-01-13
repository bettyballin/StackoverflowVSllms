import java.lang.String;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Converter_1 {
    private static final Charset EBCDIC = Charset.forName("IBM500"); // or "CP500" depending on the AS400 system

    public static String convertToEBCDIC(String textFromJava) {
        return new String(textFromJava.getBytes(StandardCharsets.US_ASCII), EBCDIC);
    }

    public static String convertToAscii(String textFromAS400) {
        return new String(textFromAS400.getBytes(EBCDIC), StandardCharsets.US_ASCII);
    }

	public static void main(String[] args) {
	}
}