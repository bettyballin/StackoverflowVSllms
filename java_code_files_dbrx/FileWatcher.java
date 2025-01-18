import java.nio.file.*;
import java.io.IOException;

public class FileWatcher {

    private boolean keepWatchingFile(Path filePath){
        try (WatchService watcher = FileSystems.getDefault().newWatchService()) {
            Path pathObj = Paths.get(""); // your file's parent directory path
            WatchKey key =  pathObj.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);
            for (;;){
                WatchKey currentKey = watcher.take();
                if (currentKey == key) { // a new event has occurred on our watched file/directory.
                    return false;
                } else { // reset key and wait for next one:
                    boolean valid = currentKey.reset();
                    if (!valid){ // not worth re-registering this key if it's already invalidated!
                        break;
                    }
                }
            }
        } catch (IOException x) {
             System.err.println(x);
        } catch (InterruptedException intrX) {
             return false; // assume interrupted == file has been deleted or locked.
        }
        return true; // We've not yet found our file being messed around with.
    }

    public static void main(String[] args) {
        // Example usage
        FileWatcher watcher = new FileWatcher();
        Path filePath = Paths.get("your_file.txt"); // Replace with your actual file path
        boolean result = watcher.keepWatchingFile(filePath);
        System.out.println("Result: " + result);
    }
}