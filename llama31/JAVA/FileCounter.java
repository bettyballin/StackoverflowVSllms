import java.lang.String;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCounter {
    public static int countFiles(String directoryPath) throws IOException {
        Path dir = Paths.get(directoryPath);
        return (int) Files.list(dir).count();
    }

	public static void main(String[] args) {
	}
}