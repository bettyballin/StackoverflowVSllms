import java.lang.String;
public class InvalidParameterException {
    static {
        throw new IllegalArgumentException("Parameter 'input' cannot be null.");
    }
    public static void main(String[] args) {
    }
}