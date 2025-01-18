import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {
        // Your original windows-1252 encoded String
        String original = "Your string here";
        byte[] w1252Bytes = original.getBytes(Charset.forName("Windows-1252"));
        String unicodeStr = new String(w1252Bytes, Charset.forName("UTF-8"));

        // Print the result
        System.out.println(unicodeStr);
    }
}