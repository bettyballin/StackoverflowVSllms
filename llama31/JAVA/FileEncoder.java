import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileEncoder {
    public static void main(String[] args) throws Exception {
        // Read a file with a specific encoding
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("file.txt"), "UTF-8"));

        // Write a file with a specific encoding
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file.txt"), "UTF-8"));
    }
}