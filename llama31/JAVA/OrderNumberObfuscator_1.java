import java.lang.String;
public class OrderNumberObfuscator_1 {
    private static final int NUM_ROUNDS = 4;
    private static final int KEY = 0x12345678; // choose a secret key

    public static long obfuscate(long actualOrderNumber) {
        long obfuscated = actualOrderNumber;
        for (int i = 0; i < NUM_ROUNDS; i++) {
            long left = (obfuscated >> 16) & 0xFFFF;
            long right = obfuscated & 0xFFFF;
            long newRight = (right + (KEY ^ left)) & 0xFFFF;
            obfuscated = (left << 16) | newRight;
        }
        return obfuscated % 1000000000L; // 9-digit output
    }

    public static long deobfuscate(long obfuscatedOrderNumber) {
        long deobfuscated = obfuscatedOrderNumber;
        for (int i = 0; i < NUM_ROUNDS; i++) {
            long left = (deobfuscated >> 16) & 0xFFFF;
            long right = deobfuscated & 0xFFFF;
            long newRight = (right - (KEY ^ left)) & 0xFFFF;
            deobfuscated = (left << 16) | newRight;
        }
        return deobfuscated;
    }

	public static void main(String[] args) {
	}
}