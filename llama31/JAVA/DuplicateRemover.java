import java.lang.String;
import java.io.*;
import java.util.HashSet;

public class DuplicateRemover {
    public static void main(String[] args) throws IOException {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            HashSet<String> uniqueLines = new HashSet<>();

            String line;
            while ((line = reader.readLine()) != null) {
                if (uniqueLines.add(line)) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        }
    }
}