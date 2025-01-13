import java.lang.String;
public class Main_122 {
    public static void main(String[] args) {
        System.out.println(getSubstringInParentheses("GREECE (+30)"));  // prints: +30
    }

    /**
     * Returns the substring within parentheses.
     *
     * @param input the input string
     * @return the substring within parentheses, or an empty string if not found
     */
    public static String getSubstringInParentheses(String input) {
        int openIndex = input.indexOf('(');
        int closeIndex = input.indexOf(')');

        if (openIndex != -1 && closeIndex != -1 && openIndex < closeIndex) {
            return input.substring(openIndex + 1, closeIndex);
        }
        return "";
    }
}