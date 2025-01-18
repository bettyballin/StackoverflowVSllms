import java.lang.String;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperations {
    public static void main(String[] args) throws IOException {
        Path sourceFile = Paths.get("source_file_path");
        Path destinationFile = Paths.get("destination_file_path");

        // To copy file/folder, use Files.copy() method
        Files.copy(sourceFile, destinationFile);

        // To move file/folder, use Files.move() method
        Path movedPath = Paths.get("new_destination_path");
        Files.move(sourceFile, movedPath);
    }
}