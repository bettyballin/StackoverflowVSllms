/*
 * Decompiled with CFR 0.152.
 */
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilePathValidator {
    public boolean isValidPath(String string) {
        try {
            Path path = Paths.get(string, new String[0]);
            return Files.exists(path.getParent(), new LinkOption[0]) || Files.exists(path, new LinkOption[0]);
        }
        catch (Exception exception) {
            return false;
        }
    }

    public static void main(String[] stringArray) {
        FilePathValidator filePathValidator = new FilePathValidator();
        System.out.println(filePathValidator.isValidPath("C:/foo"));
        System.out.println(filePathValidator.isValidPath("/foo"));
        System.out.println(filePathValidator.isValidPath("banana"));
    }
}
