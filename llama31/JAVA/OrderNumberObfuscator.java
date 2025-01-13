import java.lang.String;

public class OrderNumberObfuscator {
    public static void main(String[] args) {
        long actualOrderNumber = 12345;
        long obfuscatedOrderNumber = obfuscate(actualOrderNumber);
        System.out.println("Obfuscated: " + obfuscatedOrderNumber);

        long deobfuscatedOrderNumber = deobfuscate(obfuscatedOrderNumber);
        System.out.println("Deobfuscated: " + deobfuscatedOrderNumber);
    }

    public static long obfuscate(long orderNumber) {
        // Your obfuscation logic here
        // For demonstration purposes, a simple XOR operation is used
        return orderNumber ^ 0x12345678L;
    }

    public static long deobfuscate(long obfuscatedOrderNumber) {
        // Your deobfuscation logic here
        // For demonstration purposes, a simple XOR operation is used
        return obfuscatedOrderNumber ^ 0x12345678L;
    }
}