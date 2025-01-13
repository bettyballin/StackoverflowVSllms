import java.lang.String;
public class ExcelColumnTranslator {
    public static int translate(String column) {
        int result = 0;
        for (char c : column.toUpperCase().toCharArray()) {
            result = result * 26 + (c - 'A' + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(translate("A"));  // prints 1
        System.out.println(translate("Z"));  // prints 26
        System.out.println(translate("AA")); // prints 27
        System.out.println(translate("AZ")); // prints 52
    }
}