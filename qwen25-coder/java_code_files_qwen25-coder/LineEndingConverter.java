import java.lang.String;
import java.io.*;

public class LineEndingConverter {
    public static void main(String[] args) throws IOException {
        String inputFilePath = "input.txt";
        String outputFilePath = "output_unix.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Writes the correct newline for Unix
            }
        }
    }
}