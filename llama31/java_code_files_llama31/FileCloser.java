/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.InputStream;

public class FileCloser {
    public static void closeStream(InputStream inputStream) {
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        catch (IOException iOException) {
            throw new RuntimeException("Error closing file", iOException);
        }
    }

    public static void main(String[] stringArray) {
    }
}
