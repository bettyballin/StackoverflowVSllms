import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReaderHelper {

    private String inputPath;

    public String getInputLineByLine() throws Exception {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(inputPath))) {
            boolean start = true;
            for (String line; (line = br.readLine()) != null; ) {
                if (!start) {
                    builder.append("\r\n");
                }
                builder.append(line);
                start = false;
            }
        } catch (Throwable e){ //this is where the heap error is caught up to 2Gb
           System.err.println("Error: " + e.getMessage());
        }
        return builder.toString(); // This line could be eliminated if you are processing text and don't need it as one large string afterwards.
    }

    public static void main(String[] args) {
    }
}