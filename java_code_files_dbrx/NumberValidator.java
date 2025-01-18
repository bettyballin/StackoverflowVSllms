import java.lang.String;
public class NumberValidator {
    public boolean isANumber(String s) {
        return s.matches("[-+]?\\d*(\\.\\d+)?([Ee][-+]?\\d+)?"); // this only checks if the pattern matches, but not if it's a correct number!
    }
    public static void main(String[] args) {
    }
}