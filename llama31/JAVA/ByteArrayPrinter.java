public class ByteArrayPrinter {
    public static void main(String[] args) {
        byte[] array = new byte[] {1, 2, 3, 4};
        for (byte b : array) {
            System.out.print(String.format("%02x ", b));
        }
    }
}