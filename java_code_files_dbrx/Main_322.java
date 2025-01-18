import java.io.InputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        int byteRead;
        while ((byteRead = inputStream.read()) != -1) {
            // While there is a byte to read, do the following ...
        }
    }
}