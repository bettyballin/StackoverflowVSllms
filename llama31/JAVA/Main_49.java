import java.lang.String;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main_49 {

    public static void main(String[] args) {
        String filePath = "path/to/your/very_large_file.txt";
        try {
            System.out.println(readLastLine(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads the last line of a text file without loading the entire file into memory.
     *
     * @param filePath the path to the text file
     * @return the last line of the text file
     * @throws IOException if an I/O error occurs
     */
    public static String readLastLine(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)))) {
            String line;
            String lastLine = "";
            while ((line = reader.readLine()) != null) {
                lastLine = line;
            }
            return lastLine;
        }
    }
}