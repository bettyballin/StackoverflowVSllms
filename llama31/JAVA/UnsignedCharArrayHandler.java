public class UnsignedCharArrayHandler {
    byte[] unsignedCharArray = new byte[] { (byte) 0xFF, (byte) 0xFE, (byte) 0xFD };

    // When you need to use the byte as an unsigned char,
    // you can simply perform a bitwise AND operation with 0xFF
    int unsignedChar = unsignedCharArray[0] & 0xFF;

    public static void main(String[] args) {
        UnsignedCharArrayHandler handler = new UnsignedCharArrayHandler();
        System.out.println(handler.unsignedChar);
    }
}