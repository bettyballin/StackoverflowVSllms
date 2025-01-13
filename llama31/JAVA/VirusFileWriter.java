import java.io.FileOutputStream;
import java.io.IOException;

public class VirusFileWriter {
    public static void main(String[] args) {
        byte[][] viruses = {{/* your virus bytes here */}};
        int virusLength = viruses[0].length;
        String[] fileToInsertInNames = {"your_file_name_here"};
        for (int i = 0; i < viruses.length; i++) {
            try (FileOutputStream fileToInsertIn = new FileOutputStream(fileToInsertInNames[i])) {
                int bytesWritten = fileToInsertIn.write(viruses[i], 0, virusLength);
                if (bytesWritten != virusLength) {
                    System.err.println("Error writing to file");
                }
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
        }
    }
}