import java.lang.String;
public class NotNullValidator {
    public boolean isAnyNotNull(Object... args) {
        for (Object arg : args) {
            if (arg == null) {
                return true; // returns true as soon as it finds a null argument
            }
        }
        return false; // all arguments are non-null, hence return false
    }
    public static void main(String[] args) {
    }
}