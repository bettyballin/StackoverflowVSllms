import java.lang.String;
import java.io.*;

public class FileHandler_2 {
    public void processFile(String inputFilePath, String outputFilePath) throws IOException {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(inputFilePath));
            writer = new BufferedWriter(new FileWriter(outputFilePath));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
            }
        } finally {
            if (reader != null) {
                try { reader.close(); } catch (IOException e) { /* Handle or log exception */ }
            }
            if (writer != null) {
                try { writer.close(); } catch (IOException e) { /* Handle or log exception */ }
            }
        }
    }

	public static void main(String[] args) {
	}
}