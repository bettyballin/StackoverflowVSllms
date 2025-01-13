import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class FileWriterUtil_1_1 {
    String Shanghai_Str = "\u4E0A\u6D77";
    boolean Append = true;
    String FileName = "output.txt"; // Added file name to avoid compilation error

    public FileWriterUtil_1() throws Exception {
        File file = new File(FileName);
        FileOutputStream fos = new FileOutputStream(file, Append);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");

        osw.write(Shanghai_Str);
        osw.close();
    }

    public static void main(String[] args) throws Exception {
        new FileWriterUtil_1();
    }
}