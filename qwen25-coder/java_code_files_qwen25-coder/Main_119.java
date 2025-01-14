public class Main {
    public static void main(String[] args) throws Exception {
        String unicodeText = "\u6F22\u5B57"; // Example text
        byte[] utf16beBytes = unicodeText.getBytes("UTF-16BE");
        StringBuilder hexString = new StringBuilder();
        for (byte b : utf16beBytes) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        System.out.println(hexString.toString()); // Outputs the hex representation
    }
}