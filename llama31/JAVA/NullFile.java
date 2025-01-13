import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public interface FileWrapper {
    boolean exists();
    Scanner getScanner() throws FileNotFoundException;
    // Add other methods as needed
}

public class NullFile implements FileWrapper {
    @Override
    public boolean exists() {
        return false;
    }

    @Override
    public Scanner getScanner() throws FileNotFoundException {
        throw new FileNotFoundException("Null file");
    }
}

public class RealFile implements FileWrapper {
    private final File file;

    public RealFile(File file) {
        this.file = file;
    }

    @Override
    public boolean exists() {
        return file.exists();
    }

    @Override
    public Scanner getScanner() throws FileNotFoundException {
        return new Scanner(file);
    }

    public static void main(String[] args) {
    }
}