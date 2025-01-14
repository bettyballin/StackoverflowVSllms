import java.lang.String;
import java.io.*;

public class ReplacePlaceholder {
    public static void main(String[] args) throws IOException {
        String inputFilePath = "output_from_xslt.txt";
        String outputFilePath = "final_output_with_control_char.txt";
        
        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Replace placeholder with control character
                line = line.replace("PLACEHOLDER_FOR_CONTROL_CHAR", "\u0001");
                writer.write(line);
                writer.newLine();
            }
        }
    }
}