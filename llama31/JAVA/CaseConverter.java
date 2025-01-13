import java.lang.String;
public class CaseConverter {
    public static String toPascalCase(String text) {
        return toCamelCase(text, true);
    }

    public static String toCamelCase(String text, boolean firstUpper) {
        StringBuilder result = new StringBuilder();
        boolean upper = firstUpper;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                if (upper) {
                    result.append(Character.toUpperCase(c));
                    upper = false;
                } else {
                    result.append(Character.toLowerCase(c));
                }
            } else if (Character.isWhitespace(c) || !Character.isLetterOrDigit(c)) {
                upper = true;
            }
        }
        return result.toString();
    }

    public static String toCamelCase(String text) {
        return toCamelCase(text, false);
    }

    public static void main(String[] args) {
        String text = "mynameisfred";
        System.out.println("Camel: " + toCamelCase(text));
        System.out.println("Pascal: " + toPascalCase(text));
    }
}