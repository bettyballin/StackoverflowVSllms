import java.lang.String;
public class Base64DecoderExample {
    // Example of simple obfuscation (not recommended for serious protection)
    public static void main(String[] args) {
        String s = "HxQfM"; // Base64 encoded "Hello"
        System.out.println(new String(java.util.Base64.getDecoder().decode(s)));
    }
}