import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class CSVWriter {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("fileName.csv");
        BufferedOutputStream bos = new BufferedOutputStream(fos, 32768);
        OutputStreamWriter bufferedWriter = new OutputStreamWriter(bos);
    }
}