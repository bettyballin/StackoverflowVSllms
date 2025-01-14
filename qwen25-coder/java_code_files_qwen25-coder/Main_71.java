public class Main_71 {
    public static void main(String[] args) {
        String original = "example";
        int length = 10;
        
        // Right padding with spaces
        String rightPadded = rightPad(original, length);
        System.out.println("Right padded: '" + rightPadded + "'");
        
        // Left padding with zeros
        String leftPadded = leftPad(original, length, '0');
        System.out.println("Left padded: " + leftPadded);
    }

    public static String rightPad(String str, int size) {
        if (str == null) {
            return null;
        }
        int pads = size - str.length();
        if (pads <= 0) {
            return str; // returns original String when possible
        }
        return str + repeat(' ', pads);
    }

    public static String leftPad(String str, int size, char padChar) {
        if (str == null) {
            return null;
        }
        int pads = size - str.length();
        if (pads <= 0) {
            return str; // returns original String when possible
        }
        return repeat(padChar, pads) + str;
    }

    private static String repeat(char ch, int repeat) {
        if (repeat <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(repeat);
        for (int i = 0; i < repeat; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }
}