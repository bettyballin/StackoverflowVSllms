import java.lang.String;

public class PreconditionValidator {
    static String state;

    static {
        assert state != null : "State must not be null";
    }

    public static void main(String[] args) {
    }
}