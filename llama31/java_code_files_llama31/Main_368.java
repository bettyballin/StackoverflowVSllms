/*
 * Decompiled with CFR 0.152.
 */
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class Main_368 {
    public static void main(String[] stringArray) throws Exception {
        String string = "Your windows-1252 encoded string here";
        CharsetDecoder charsetDecoder = Charset.forName("windows-1252").newDecoder();
        CharsetEncoder charsetEncoder = Charset.forName("UTF-8").newEncoder();
        CharBuffer charBuffer = charsetDecoder.decode(ByteBuffer.wrap(string.getBytes("windows-1252")));
        ByteBuffer byteBuffer = charsetEncoder.encode(charBuffer);
        String string2 = new String(byteBuffer.array(), "UTF-8");
        System.out.println(string2);
    }
}
