public class HexPrinter {
    public static void main(String[] args) {
        int x = 36; // Example value for x
        for (int i = 1; i <= x; i++) {
            System.out.printf("%02x\n", i);
        }
    }
}