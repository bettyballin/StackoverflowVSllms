/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class CompressionUtil {
    public static void main(String[] stringArray) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("output.gz");
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(fileOutputStream);
        gZIPOutputStream.close();
    }
}
