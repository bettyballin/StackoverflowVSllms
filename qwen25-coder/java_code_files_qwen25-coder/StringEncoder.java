public class StringEncoder {
    // Example of simple string encoding in Java (not full-proof)
    private static String encode(String data) {
        char[] encoded = new char[data.length()];
        for (int i = 0; i < data.length(); i++) {
            encoded[i] = (char)(data.charAt(i) ^ 0xFF);
        }
        return new String(encoded);
    }

    public static void main(String[] args) {
    }
}