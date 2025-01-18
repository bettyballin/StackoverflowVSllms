import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateLines {
    public static void main(String[] args) throws IOException {
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {
            Set<String> lines = new HashSet<>();
            String line;
            while ((line = reader.readLine()) != null) {
                if (lines.add(line)) { // add returns true only if the line is unique, and in that case we write it to output file
                    writer.println(line);
                }
            }
        }
        System.out.println("De-duplication complete!");
    }
}