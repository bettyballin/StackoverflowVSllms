import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;

public class Main_594_594 {
    public static void main(String[] args) throws IOException {
        File file = new File("sparse_file");
        try (FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            channel.truncate(10 * 1024 * 1024); // Set the file size to 10MB
        }
    }
}