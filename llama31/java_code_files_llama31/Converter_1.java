/*
 * Decompiled with CFR 0.152.
 */
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Converter_1 {
    private static final Charset EBCDIC = Charset.forName("IBM500");

    public static String convertToEBCDIC(String string) {
        return new String(string.getBytes(StandardCharsets.US_ASCII), EBCDIC);
    }

    public static String convertToAscii(String string) {
        return new String(string.getBytes(EBCDIC), StandardCharsets.US_ASCII);
    }

    public static void main(String[] stringArray) {
    }
}
