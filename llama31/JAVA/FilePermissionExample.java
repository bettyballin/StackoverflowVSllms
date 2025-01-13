import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashSet;
import java.util.Set;

public class FilePermissionExample {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("/path/to/your/file.txt");

        // Change file permissions
        Set<PosixFilePermission> perms = new HashSet<>();
        perms.add(PosixFilePermission.OWNER_READ);
        perms.add(PosixFilePermission.OWNER_WRITE);
        perms.add(PosixFilePermission.GROUP_READ);
        Files.setPosixFilePermissions(filePath, perms);

        // Change last modified date
        long newLastModified = System.currentTimeMillis();
        Files.setLastModifiedTime(filePath, java.nio.file.attribute.FileTime.fromMillis(newLastModified));
    }
}