import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.SecureRandom;

public class SecureDelete {

    private static final int OVERWRITE_PASSES = 3; // Number of overwrite passes

    public static void secureDelete(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File does not exist: " + file.getAbsolutePath());
        }

        Path path = file.toPath();
        long length = Files.size(path);

        SecureRandom random = new SecureRandom();

        for (int pass = 0; pass < OVERWRITE_PASSES; pass++) {
            byte[] bytes = new byte[(int) length];
            random.nextBytes(bytes);

            try (java.io.RandomAccessFile raf = new java.io.RandomAccessFile(file, "rw")) {
                raf.write(bytes);
            }
        }

        Files.delete(path);
    }

    public static void main(String[] args) {
        File fileToDelete = new File("path/to/your/file.txt");
        try {
            secureDelete(fileToDelete);
            System.out.println("File securely deleted.");
        } catch (IOException e) {
            errorHandle(e);
        }
    }

    private static void errorHandle(IOException e){
        System.err.println("An I/O error occurred: " + e.getMessage());
    }
}