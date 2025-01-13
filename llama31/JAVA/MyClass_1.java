import java.io.FileNotFoundException;
import java.util.Scanner;

class FileWrapper {
    private java.io.File file;

    public FileWrapper(java.io.File file) {
        this.file = file;
    }

    public boolean exists() {
        return file.exists();
    }

    public Scanner getScanner() throws FileNotFoundException {
        return new Scanner(file);
    }
}

public class MyClass_1_1 {
    public void processFile(FileWrapper file) {
        if (file != null && file.exists()) {
            try (Scanner scanner = file.getScanner()) {
                // Process the file
            } catch (FileNotFoundException e) {
                // Handle exception
            }
        } else {
            // Handle null or non-existent file case
        }
    }

    public static void main(String[] args) {
    }
}