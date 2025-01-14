import java.util.Base64;

public class Base64Example {
    public void encodeString(String input) {
        String encoded = Base64.getEncoder().encodeToString(input.getBytes());
        System.out.println(encoded);
    }

    public static void main(String[] args) {
    }
}