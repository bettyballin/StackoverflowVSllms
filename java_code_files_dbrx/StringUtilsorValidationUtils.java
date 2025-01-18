public class StringUtilsorValidationUtils {
    public static boolean isNumeric(String str) {
        return str != null && (str.matches("-?\\d+(\\.\\d+)?"));
    }
    public static void main(String[] args) {
    }
}