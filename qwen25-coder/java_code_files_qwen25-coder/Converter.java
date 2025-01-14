import java.lang.String;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class Converter {

    private static final Charset ASCII_CHARSET = Charset.forName("ASCII");
    private static final Charset EBCDIC_CHARSET = Charset.forName("IBM1047");

    public static byte[] convertToEBCDIC(String textFromJava) {
        return textFromJava.getBytes(EBCDIC_CHARSET);
    }

    public static String convertToAscii(byte[] textFromEBCDIC) {
        return new String(textFromEBCDIC, ASCII_CHARSET);
    }
    
    // If you need to convert from EBCDIC bytes directly back to Java string:
    public static String convertEBCDICBytesToString(byte[] textFromEBCDIC) {
        CharBuffer buffer = EBCDIC_CHARSET.decode(ByteBuffer.wrap(textFromEBCDIC));
        return new String(buffer.array());
    }

    public static void main(String[] args) {
        String asciiString = "Hello, World!";
        byte[] ebcdicBytes = convertToEBCDIC(asciiString);
        System.out.println("Converted to EBCDIC: " + new String(ebcdicBytes)); // This will show gibberish

        String asciiBack = convertEBCDICBytesToString(ebcdicBytes);
        System.out.println("Converted back to ASCII: " + asciiBack);
    }
}