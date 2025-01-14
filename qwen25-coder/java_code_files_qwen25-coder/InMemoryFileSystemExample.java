import java.lang.String;
import com.google.common.jimfs.Configuration;
import com.google.common.jimfs.Jimfs;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;

public class InMemoryFileSystemExample {
    public static void main(String[] args) throws IOException {
        FileSystem fs = Jimfs.newFileSystem(Configuration.unix());
        Path path = fs.getPath("/file.txt");

        String content = "In-memory file example";
        Files.write(path, content.getBytes(StandardCharsets.UTF_8));

        byte[] result = Files.readAllBytes(path);
        System.out.println(new String(result, StandardCharsets.UTF_8));
    }
}