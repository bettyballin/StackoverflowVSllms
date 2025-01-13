/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

static class FolderScanner.1
extends SimpleFileVisitor<Path> {
    FolderScanner.1() {
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        System.out.println(path.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }
}
