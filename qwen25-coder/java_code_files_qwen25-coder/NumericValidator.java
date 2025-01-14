import java.lang.String;
public class NumericValidator {
    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) return false;
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void main(String[] args) {
    }
}