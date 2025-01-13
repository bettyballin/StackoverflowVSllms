import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermissions;
import java.nio.file.StandardCopyOption;
import java.util.Set;

public class MoveFileWithACLs {
    public static void main(String[] args) throws IOException {
        Path tempFile = Paths.get("/tmp/tempfile.txt");
        Path finalFile = Paths.get("/path/to/final/file.txt");

        // Create a temporary file with specific ACLs
        Files.createFile(tempFile);
        // Set ACLs on the temporary file
        Files.setPosixFilePermissions(tempFile, PosixFilePermissions.fromString("rwxr-x---"));

        // Move the temporary file to the final directory, preserving ACLs
        Files.move(tempFile, finalFile, StandardCopyOption.REPLACE_EXISTING);

        // Verify the ACLs on the moved file
        System.out.println(Files.getPosixFilePermissions(finalFile));
    }
}