/*
 * Decompiled with CFR 0.152.
 */
import java.io.PrintWriter;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Main_246 {
    public static void main(String[] stringArray) {
        String string = "example/file.txt";
        FileSystem fileSystem = FileSystems.getDefault();
        Path path = fileSystem.getPath(System.getProperty("user.home"), string);
        Path path2 = fileSystem.getPath(System.getProperty("user.home"), fileSystem.getPath(string, new String[0]).getFileName().toString().replace('/', '_'));
        try (PrintWriter printWriter = new PrintWriter(path2.toFile());){
            printWriter.println("Hello, World!");
        }
        catch (Exception exception) {
            System.out.println("An error occurred: " + exception.getMessage());
        }
    }
}
