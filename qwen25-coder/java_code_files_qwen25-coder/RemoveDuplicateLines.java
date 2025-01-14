import java.lang.String;
import java.io.*;
import java.util.HashSet;

public class RemoveDuplicateLines {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            HashSet<String> uniqueLines = new HashSet<>();
            String currentLine;
            
            while ((currentLine = reader.readLine()) != null) {
                if (uniqueLines.add(currentLine)) { // add returns false if the set already contains the line
                    writer.write(currentLine);
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            System.err.println("An error occurred while processing files: " + e.getMessage());
        }
    }
}