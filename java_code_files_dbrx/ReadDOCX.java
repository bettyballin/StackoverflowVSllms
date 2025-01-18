import java.lang.String;
import java.io.*;
public class ReadDOCX {
    public static void main(String[] args) throws IOException {
        File file = new File("input_path/file_name.txt"); // replace with your docx converted into .txt path & name
        FileInputStream fis = new FileInputStream(file);
        int content;
        while ((content = fis.read()) != -1) {
            System.out.print((char) content);
        }
    }
}