import java.lang.String;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderHelper {
    static {
        try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
    }
}