import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

    private static String readFileAsString(String filePath, String encoding) throws IOException {
        StringBuffer fileData = new StringBuffer(1000);
        FileInputStream fis = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(fis, encoding);
        BufferedReader reader = new BufferedReader(isr);
        char[] buf = new char[1024];
        int numRead;
        while ((numRead = reader.read(buf)) != -1) {
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        return fileData.toString();
    }
}