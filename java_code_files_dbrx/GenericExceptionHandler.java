import java.lang.String;

public class GenericExceptionHandler {

    public static void main(String[] args) {
        try {
            // some code
        } catch (Exception e) {
            throw new RuntimeException("An error occurred during the execution of the program.", e);
        }
    }
}