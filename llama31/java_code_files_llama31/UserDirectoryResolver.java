/*
 * Decompiled with CFR 0.152.
 */
import java.nio.file.Path;
import java.nio.file.Paths;

public class UserDirectoryResolver {
    Path userHome = Paths.get(System.getProperty("user.home"), new String[0]);
    Path libraryDir = this.userHome.resolve("Library");

    public static void main(String[] stringArray) {
    }
}
