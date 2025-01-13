/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermissions;

public class MoveFileWithACLs {
    public static void main(String[] stringArray) throws IOException {
        Path path = Paths.get("/tmp/tempfile.txt", new String[0]);
        Path path2 = Paths.get("/path/to/final/file.txt", new String[0]);
        Files.createFile(path, new FileAttribute[0]);
        Files.setPosixFilePermissions(path, PosixFilePermissions.fromString("rwxr-x---"));
        Files.move(path, path2, StandardCopyOption.REPLACE_EXISTING);
        System.out.println(Files.getPosixFilePermissions(path2, new LinkOption[0]));
    }
}
