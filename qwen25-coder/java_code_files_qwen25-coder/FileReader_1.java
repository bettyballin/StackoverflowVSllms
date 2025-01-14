import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Define an interface for file operations
interface FileHandler {
    boolean exists();
    Scanner createScanner() throws FileNotFoundException;
}

// Implement the interface for actual files
class RealFileHandler implements FileHandler {
    private final File file;

    public RealFileHandler(File file) {
        this.file = file;
    }

    @Override
    public boolean exists() {
        return file.exists();
    }

    @Override
    public Scanner createScanner() throws FileNotFoundException {
        if (exists()) {
            return new Scanner(file);
        }
        throw new FileNotFoundException("The file " + file.getAbsolutePath() + " does not exist.");
    }
}

// Implement the Null Object variant
class NullFileHandler implements FileHandler {

    @Override
    public boolean exists() {
        return false;
    }

    @Override
    public Scanner createScanner() throws FileNotFoundException {
        throw new FileNotFoundException("No file provided.");
    }
}

// Example usage in your class
public class FileReader_1 {
    private final FileHandler fileHandler;

    // Use a Null Object if no file is provided
    public FileReader_1(File file) {
        this.fileHandler = (file == null ? new NullFileHandler() : new RealFileHandler(file));
    }

    public void readFileContent() {
        if (!fileHandler.exists()) {
            System.out.println("No file to read.");
            return;
        }
        
        try (Scanner scanner = fileHandler.createScanner()) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Process the line
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Test with a real file
        FileReader_1 readerWithFile = new FileReader_1(new File("example.txt"));
        readerWithFile.readFileContent();

        // Test without any file (null passed)
        FileReader_1 readerWithoutFile = new FileReader_1(null);
        readerWithoutFile.readFileContent();
    }
}