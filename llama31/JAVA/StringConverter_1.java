import java.lang.String;

public class StringConverter_1_1 {
    public String convertEmptyString(String value) {
        if (value == null || value.isEmpty()) {
            return "@";
        }
        return value;
    }

    public String revertEmptyString(String value) {
        if (value.equals("@")) {
            return "";
        }
        return value;
    }

    public static void main(String[] args) {
        StringConverter_1 converter = new StringConverter_1();
        System.out.println(converter.convertEmptyString(null));  // prints "@"
        System.out.println(converter.convertEmptyString(""));   // prints "@"
        System.out.println(converter.convertEmptyString("abc")); // prints "abc"

        System.out.println(converter.revertEmptyString("@"));  // prints ""
        System.out.println(converter.revertEmptyString(""));   // prints ""
        System.out.println(converter.revertEmptyString("abc")); // prints "abc"
    }
}