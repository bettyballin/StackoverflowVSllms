import java.io.ByteArrayOutputStream;
import java.lang.String;

public class RLECompressor {
    public static byte[] compress(byte[] input) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int count = 1;
        for (int i = 1; i < input.length; i++) {
            if (input[i] == input[i - 1]) {
                count++;
            } else {
                out.write(count);
                out.write(input[i - 1]);
                count = 1;
            }
        }
        out.write(count);
        out.write(input[input.length - 1]);
        return out.toByteArray();
    }

    public static byte[] decompress(byte[] input) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        for (int i = 0; i < input.length; i += 2) {
            int count = input[i];
            byte b = input[i + 1];
            for (int j = 0; j < count; j++) {
                out.write(b);
            }
        }
        return out.toByteArray();
    }

    public static void main(String[] args) {
    }
}