// Example of compressing JSON using Gzip in Java
import java.util.zip.GZIPOutputStream;
import java.io.*;

public class Compressor {

    public static byte[] compress(String str) throws IOException {
        ByteArrayOutputStream obj = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(obj);
        gzip.write(str.getBytes("UTF-8"));
        gzip.close();
        return obj.toByteArray();
    }

}