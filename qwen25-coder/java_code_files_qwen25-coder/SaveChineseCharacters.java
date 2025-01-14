import java.lang.String;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveChineseCharacters {
    public static void main(String[] args) {
        String Shanghai_StrBuf = "\u4E0A\u6D77";
        boolean append = true;
        String fileName = "output.txt"; // Specify your file name here

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, append))) {
            writer.write(Shanghai_StrBuf);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}