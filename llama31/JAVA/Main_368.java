import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class Main_368 {
    public static void main(String[] args) throws Exception {
        String windows1252String = "Your windows-1252 encoded string here";

        CharsetDecoder decoder = Charset.forName("windows-1252").newDecoder();
        CharsetEncoder encoder = Charset.forName("UTF-8").newEncoder();
        CharBuffer charBuffer = decoder.decode(ByteBuffer.wrap(windows1252String.getBytes("windows-1252")));
        ByteBuffer byteBuffer = encoder.encode(charBuffer);
        String unicodeString = new String(byteBuffer.array(), "UTF-8");

        System.out.println(unicodeString);
    }
}