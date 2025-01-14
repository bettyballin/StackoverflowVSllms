import java.lang.String;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileValidator {

    // Method to check if the filename follows the naming convention and is a tsv file
    public boolean isValidTsvFilename(String fileName) {
        return fileName != null && fileName.toLowerCase().matches("^[a-zA-Z0-9_]+\\.tsv$");
    }

    // Method to check if the content of the file is a valid TSV format (basic check: has tab-separated values)
    public boolean isValidTsvContent(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            // Very basic check if there's at least one tab character in each line
            if (line.indexOf('\t') == -1 && !line.trim().isEmpty()) {
                reader.close();
                return false;
            }
        }
        reader.close();
        return true;
    }

    public static void main(String[] args) throws IOException {
        FileValidator validator = new FileValidator();
        String fileName = "example.tsv";
        File file = new File(fileName);

        if (validator.isValidTsvFilename(fileName)) {
            System.out.println("File name is valid.");
            if (file.exists() && validator.isValidTsvContent(file)) {
                System.out.println("TSV file content is valid.");
            } else {
                System.out.println("TSV file content is invalid or the file does not exist.");
            }
        } else {
            System.out.println("Invalid file name for a TSV file.");
        }
    }
}