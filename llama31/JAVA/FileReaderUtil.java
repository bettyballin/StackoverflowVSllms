import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.String;

public class FileReaderUtil {
    private static String readFileAsString(String filePath) throws IOException {
        StringBuffer fileData = new StringBuffer(1000);
        FileInputStream fis = new FileInputStream(filePath);
        InputStreamReader reader = new InputStreamReader(fis, "UTF-8"); // Specify UTF-8 encoding
        BufferedReader br = new BufferedReader(reader);
        char[] buf = new char[1024];
        int numRead = 0;
        while ((numRead = br.read(buf)) != -1) {
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
            buf = new char[1024];
        }
        br.close();
        return fileData.toString();
    }

    public static void main(String[] args) {
    }
}