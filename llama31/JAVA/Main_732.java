import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Main_732 {
    public static void main(String[] args) throws IOException {
        String jsonString = "{\"key\":\"value\"}"; // replace with your JSON string
        byte[] jsonBytes = jsonString.getBytes();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(bos);
        gzip.write(jsonBytes);
        gzip.close();
        byte[] compressedBytes = bos.toByteArray();

        System.out.println(compressedBytes.length + " bytes compressed");
    }
}