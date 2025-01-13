/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;

public class DirectoryRestrictor {
    public static void restrictAccess(File file) throws Exception {
        HashSet<PosixFilePermission> hashSet = new HashSet<PosixFilePermission>();
        hashSet.add(PosixFilePermission.OWNER_READ);
        hashSet.add(PosixFilePermission.OWNER_WRITE);
        hashSet.add(PosixFilePermission.OWNER_EXECUTE);
        Files.setPosixFilePermissions(file.toPath(), hashSet);
    }

    public static void main(String[] stringArray) throws Exception {
        File file = new File("/path/to/work/directory");
        DirectoryRestrictor.restrictAccess(file);
    }
}
