import java.lang.String;

public class Validator_1_1 {
    public void myMethod(String param1, int param2, boolean param3) {
        if (!param1.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("Invalid input");
        }
        // method body
    }

    public static void main(String[] args) {
        Validator_1 validator = new Validator_1();
        try {
            validator.myMethod("HelloWorld123", 10, true);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}