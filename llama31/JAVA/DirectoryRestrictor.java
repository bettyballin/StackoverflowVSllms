import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashSet;
import java.util.Set;

public class DirectoryRestrictor {
    public static void restrictAccess(File directory) throws Exception {
        // Get the current permissions
        Set<PosixFilePermission> perms = new HashSet<>();
        perms.add(PosixFilePermission.OWNER_READ);
        perms.add(PosixFilePermission.OWNER_WRITE);
        perms.add(PosixFilePermission.OWNER_EXECUTE);

        // Set the new permissions
        Files.setPosixFilePermissions(directory.toPath(), perms);
    }

    public static void main(String[] args) throws Exception {
        File workDir = new File("/path/to/work/directory");
        restrictAccess(workDir);
    }
}