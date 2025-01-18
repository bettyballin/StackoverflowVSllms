import java.lang.String;
public class InvalidSsnException extends IllegalArgumentException {
    public InvalidSsnException(String message) {
        super(message);
    }

	public static void main(String[] args) {
	}
}