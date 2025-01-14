import java.lang.String;
public class NumberStringParser {
    public static void main(String[] args) {
        String str = "hello";
        if (str.matches("-?\\d+(\\.\\d+)?")) { // Matches optional negative sign, digits, optional decimal point and more digits
            try {
                Double.parseDouble(str);
                System.out.println("Converted successfully: " + str);
            } catch (NumberFormatException e) {
                System.out.println("Cannot convert to double: " + str); // This should not be reached with the regex check
            }
        } else {
            System.out.println("Invalid number format: " + str);
        }
    }
}