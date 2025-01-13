/*
 * Decompiled with CFR 0.152.
 */
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileExporter {
    public void exportFileFromJar(String string, String string2) throws Exception {
        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(string);){
            if (inputStream == null) {
                throw new Exception("Resource not found: " + string);
            }
            try (OutputStream outputStream = Files.newOutputStream(Paths.get(string2, new String[0]), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);){
                int n;
                byte[] byArray = new byte[1024];
                while ((n = inputStream.read(byArray)) != -1) {
                    outputStream.write(byArray, 0, n);
                }
            }
        }
    }

    public static void main(String[] stringArray) throws Exception {
        FileExporter fileExporter = new FileExporter();
        fileExporter.exportFileFromJar("com/test/io/test.txt", "/path/to/your/target/file.txt");
    }
}
