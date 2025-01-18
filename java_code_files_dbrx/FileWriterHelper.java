import java.lang.String;
public class FileWriterHelper {
    static java.io.OutputStream os;
    static byte[] fileData;

    static {
        os.write(fileData);
        os.flush();
        os.close();
    }

    public static void main(String[] args) {
    }
}