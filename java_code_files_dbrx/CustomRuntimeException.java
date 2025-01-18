import java.lang.String;
public class CustomRuntimeException extends RuntimeException{
  public CustomRuntimeException(String message, Throwable cause) {
     super(message, cause);
  }

	public static void main(String[] args) {
	}
}