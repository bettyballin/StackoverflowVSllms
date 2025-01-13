import java.io.FileWriter;
import java.io.IOException;

public class VirusWriter {
    public static void main(String[] args) {
        String[] viruses = {"Virus1", "Virus2", "Virus3"}; // Example virus array
        int virusLength = viruses[0].length(); // Get the length of the first virus

        try (FileWriter fileToInsertIn = new FileWriter("output.txt")) {
            for (int i = 0; i < viruses.length; i++) {
                fileToInsertIn.write(viruses[i], 0, virusLength);
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}