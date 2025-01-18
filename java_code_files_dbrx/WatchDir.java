import java.io.IOException;
import java.nio.file.*;

public class WatchDir {
    public static void main(String[] args) throws Exception {
        Path dir = Paths.get("C:/your-directory");
        WatchService watcher;
        try {
            watcher = FileSystems.getDefault().newWatchService();
            dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);

            while (true) {
                WatchKey key = watcher.take();

                for (WatchEvent<?> event : key.pollEvents()) {
                    System.out.println("Created file: " + event.context());
                    // Add your DB update process here to handle this newly added file.
                }

                if (!key.reset()) {
                    break; // loop is done, the dir been deleted in watch events case.
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}