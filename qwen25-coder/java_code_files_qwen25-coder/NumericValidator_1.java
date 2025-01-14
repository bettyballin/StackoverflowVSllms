import java.lang.String;
public class NumericValidator_1 {
    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) return false;
        String regex = "-?\\d+(\\.\\d+)?";
        return str.matches(regex);
    }
    public static void main(String[] args) {
    }
}