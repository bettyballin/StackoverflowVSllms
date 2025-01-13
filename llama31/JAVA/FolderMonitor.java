import java.io.IOException;
import java.nio.file.*;
import java.nio.file.WatchEvent.Kind;

public class FolderMonitor {
  public static void main(String[] args) {
    Path dir = Paths.get("/path/to/folder");
    try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
      dir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
          StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

      while (true) {
        WatchKey key = watchService.take();
        for (WatchEvent<?> event : key.pollEvents()) {
          Kind<?> kind = event.kind();
          Path name = (Path) event.context();
          Path child = dir.resolve(name);

          if (name.toString().startsWith("img")) {
            // Only process events for files starting with "img"
            System.out.println(kind + ": " + child);
          }
        }
        key.reset();
      }
    } catch (IOException | InterruptedException e) {
      System.err.println(e.getMessage());
    }
  }
}