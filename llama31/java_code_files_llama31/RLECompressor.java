/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayOutputStream;

public class RLECompressor {
    public static byte[] compress(byte[] byArray) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n = 1;
        for (int i = 1; i < byArray.length; ++i) {
            if (byArray[i] == byArray[i - 1]) {
                ++n;
                continue;
            }
            byteArrayOutputStream.write(n);
            byteArrayOutputStream.write(byArray[i - 1]);
            n = 1;
        }
        byteArrayOutputStream.write(n);
        byteArrayOutputStream.write(byArray[byArray.length - 1]);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] decompress(byte[] byArray) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < byArray.length; i += 2) {
            int n = byArray[i];
            byte by = byArray[i + 1];
            for (int j = 0; j < n; ++j) {
                byteArrayOutputStream.write(by);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void main(String[] stringArray) {
    }
}
