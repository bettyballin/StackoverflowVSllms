import java.lang.String;

public class DoubleValidator {
    public boolean isValidDouble(String strNumber) {
        try {
            Double.parseDouble(strNumber);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
    }
}