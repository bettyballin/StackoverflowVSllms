import java.lang.String;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class FileReaderUTF16 {
    public static void main(String[] args) {
        try (InputStream fis = new FileInputStream("inputFile.txt"); // InputStream for reading the file
             BufferedReader reader = new BufferedReader(new InputStreamReader(fis, "UTF-16"))) {  // wrap within an input stream and encode it using UTF-16
            String line;
            while ((line = reader.readLine()) != null) {
                // your code for handling the read line goes here
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}