import java.lang.String;
public class Example_8 {
    // Field accessible within this class and its subclasses
    private int secretValue = 42;

    public static void main(String[] args) {
        Example_8 example = new Example_8();
        System.out.println("secretValue - " + example.getSecretValue());
    }

    // Public method allowing the access to our field's value
    public int getSecretValue() {
        return secretValue;
    }
}