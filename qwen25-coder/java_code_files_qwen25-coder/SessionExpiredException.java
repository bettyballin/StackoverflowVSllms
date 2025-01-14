import java.lang.String;
public class SessionExpiredException extends RuntimeException {
    public SessionExpiredException(String message) {
        super(message);
    }

    public static void main(String[] args) {
    }
}