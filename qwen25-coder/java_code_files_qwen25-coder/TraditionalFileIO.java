import java.lang.String;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TraditionalFileIO {
    // Traditional File IO (old way)
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("filename.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    // handle exception
                }
            }
        }
    }
}