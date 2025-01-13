import java.lang.String;
public class Adler32Checksum {
    public static int adler32(byte[] data) {
        int a = 1;
        int b = 0;
        for (byte byteValue : data) {
            a = (a + byteValue) % 65521;
            b = (b + a) % 65521;
        }
        return (b << 16) + a;
    }

	public static void main(String[] args) {
	}
}