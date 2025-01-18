import java.security.*;
import java.nio.charset.StandardCharsets;
import javax.xml.bind.DatatypeConverter;

public class UUIDv5Example {
    public static void main(String[] args) throws Exception {
        byte[] namespace = DatatypeConverter.parseHexBinary("6ba7b8109dad11d180b400c04fd430c8");
        byte[] name      = "mail@domain.com".getBytes(StandardCharsets.UTF_8);
        MessageDigest md = MessageDigest.getInstance("SHA-1");

        byte[] hash = md.digest(concat(namespace, name));
        long mostSig  = 0;
        long leastSig = 0;

        for (int i = 0; i < 16; i++) {
            if (i < 8) {
                mostSig = (mostSig << 8) | (hash[i] & 0xFF);
            } else {
                leastSig = (leastSig << 8) | (hash[i] & 0xFF);
            }
        }

        // Set the version number to 5 (four bits)
        mostSig &= ~(0xF000L);
        mostSig |= 0x5000L;

        // Set the variant to IETF variant (two bits)
        leastSig &= ~(0xC000000000000000L);
        leastSig |= 0x8000000000000000L;

        System.out.printf("%08x-%04x-%04x-%04x-%012x\n",
            (mostSig >> 32) & 0xFFFFFFFF,
            (mostSig >> 16) & 0xFFFF,
            mostSig & 0xFFFF,
            (leastSig >> 48) & 0xFFFF,
            leastSig & 0xFFFFFFFFFFFFL);
    }

    private static byte[] concat(byte[] a, byte[] b) {
        byte[] c = new byte[a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        return c;
    }
}