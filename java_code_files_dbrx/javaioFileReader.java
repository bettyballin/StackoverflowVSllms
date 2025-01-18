import java.lang.String;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class javaioFileReader {

    FileReader fr;

    public javaioFileReader() throws FileNotFoundException {
        fr = new FileReader("example.txt"); // Could be restricted based on policy and origin
    }

    public static void main(String[] args) throws FileNotFoundException {
    }
}