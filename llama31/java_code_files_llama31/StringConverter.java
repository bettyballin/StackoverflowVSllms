/*
 * Decompiled with CFR 0.152.
 */
import java.io.UnsupportedEncodingException;

public class StringConverter {
    String windows1252String = "\u03a0\u03b1\u03c1\u03ac\u03b4\u03b5\u03b9\u03b3\u03bc\u03b1";
    String unicodeString = new String(this.windows1252String.getBytes("windows-1252"), "UTF-8");

    public static void main(String[] stringArray) {
        try {
            StringConverter stringConverter = new StringConverter();
            System.out.println(stringConverter.unicodeString);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            System.out.println("Unsupported encoding exception: " + unsupportedEncodingException.getMessage());
        }
    }
}
