import javax.crypto.*;
import java.security.*;
import java.util.Base64;

public class Main {
    // Declaration of byteArr
    static byte[] byteArr;

    public static void main(String[] args) throws Exception {
        // Assume byteArr is defined elsewhere or initialized before usage

        char[] chars = Base64.getEncoder().encodeToString(byteArr).toCharArray();  // This will give you a larger char array as the length grows.

        // Example usage: print chars
        System.out.println(chars);
    }
}