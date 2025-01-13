/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class FileMonitor {
    public static void main(String[] stringArray) throws IOException {
        Path path = Paths.get("/path/to/your/file.csv", new String[0]);
        WatchService watchService = FileSystems.getDefault().newWatchService();
        path.getParent().register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
        while (true) {
            WatchKey watchKey;
            try {
                watchKey = watchService.take();
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
                break;
            }
            for (WatchEvent<?> watchEvent : watchKey.pollEvents()) {
                if (watchEvent.kind() == StandardWatchEventKinds.ENTRY_MODIFY && !watchEvent.context().equals(path.getFileName())) continue;
            }
            watchKey.reset();
        }
    }
}
