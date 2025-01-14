import java.lang.String;
public class InvalidSsnException extends IllegalArgumentException {
       private final String errorCode;

       public InvalidSsnException(String s, String errorCode) {
           super(s);
           this.errorCode = errorCode;
       }

       public String getErrorCode() {
           return errorCode;
       }

       public static void main(String[] args) {
       }
}