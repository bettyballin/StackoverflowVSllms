/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;

public class FilePermissionExample {
    public static void main(String[] stringArray) throws IOException {
        Path path = Paths.get("/path/to/your/file.txt", new String[0]);
        HashSet<PosixFilePermission> hashSet = new HashSet<PosixFilePermission>();
        hashSet.add(PosixFilePermission.OWNER_READ);
        hashSet.add(PosixFilePermission.OWNER_WRITE);
        hashSet.add(PosixFilePermission.GROUP_READ);
        Files.setPosixFilePermissions(path, hashSet);
        long l = System.currentTimeMillis();
        Files.setLastModifiedTime(path, FileTime.fromMillis(l));
    }
}
