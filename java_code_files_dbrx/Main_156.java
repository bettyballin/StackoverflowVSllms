public class Main {
    public static void main(String[] args) {
        String result = Strings.padStart("Hello", 10, '0');  // "00000Hello"
        System.out.println(result);
        result = Strings.padEnd("World", 8, '-');           // "World---"
        System.out.println(result);
    }
}

class Strings {
    public static String padStart(String string, int minLength, char padChar) {
        if (string.length() >= minLength) {
            return string;
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < minLength - string.length(); i++) {
                sb.append(padChar);
            }
            sb.append(string);
            return sb.toString();
        }
    }

    public static String padEnd(String string, int minLength, char padChar) {
        if (string.length() >= minLength) {
            return string;
        } else {
            StringBuilder sb = new StringBuilder(string);
            for (int i = 0; i < minLength - string.length(); i++) {
                sb.append(padChar);
            }
            return sb.toString();
        }
    }
}