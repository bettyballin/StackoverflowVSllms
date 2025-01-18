import java.lang.String;
import java.nio.file.*;
import java.io.IOException;

public class FileWatchService {

    private Path dirName;
    private WatchService watcher;
    private String prefix;

    public FileWatchService() throws IOException {
        this.dirName = Paths.get("some/directory");
        this.watcher = FileSystems.getDefault().newWatchService();
        this.prefix = "somePrefix";

        dirName.register(this.watcher, StandardWatchEventKinds.ENTRY_CREATE); // Registering for create file event only in this case.

        // With this one
        dirName.register(watcher, new WatchEvent.Kind<?>[] {StandardWatchEventKinds.ENTRY_CREATE}, DirectoryModificationFilter(prefix));
    }

    private WatchEvent.Modifier DirectoryModificationFilter(String prefix) {
        // For the purpose of compiling, return a dummy Modifier
        return new WatchEvent.Modifier() {
            @Override
            public String name() {
                return "DirectoryModificationFilter";
            }
        };
    }

    public static void main(String[] args) {
        try {
            new FileWatchService();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}