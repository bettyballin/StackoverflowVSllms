import java.lang.String;

public class KeyGenerator_1_1 {
    String email; // declare email variable
    final String key;

    public KeyGenerator_1(String email) {
        this.email = email;
        this.key = ("Data-" + email).intern();
    }

    public static void main(String[] args) {
        KeyGenerator_1 kg = new KeyGenerator_1("example@example.com");
        System.out.println(kg.key);
    }
}