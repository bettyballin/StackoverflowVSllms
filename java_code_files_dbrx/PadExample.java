public class PadExample {
    public static void main(String[] args) {
        String result = leftPad("Hello", 10, '0'); // "00000Hello"
        System.out.println(result);

        result = rightPad("World", 8, '-');        // "World---"
        System.out.println(result);
    }

    public static String leftPad(String str, int size, char padChar) {
        if (str == null) {
            return null;
        }
        int pads = size - str.length();
        if (pads <= 0) {
            return str;
        }
        StringBuilder pad = new StringBuilder();
        for (int i = 0; i < pads; i++) {
            pad.append(padChar);
        }
        return pad.append(str).toString();
    }

    public static String rightPad(String str, int size, char padChar) {
        if (str == null) {
            return null;
        }
        int pads = size - str.length();
        if (pads <= 0) {
            return str;
        }
        StringBuilder padded = new StringBuilder(str);
        for (int i = 0; i < pads; i++) {
            padded.append(padChar);
        }
        return padded.toString();
    }
}