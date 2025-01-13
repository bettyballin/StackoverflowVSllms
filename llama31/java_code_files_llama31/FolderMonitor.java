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

public class FolderMonitor {
    public static void main(String[] stringArray) {
        Path path = Paths.get("/path/to/folder", new String[0]);
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            try {
                path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
                while (true) {
                    WatchKey watchKey = watchService.take();
                    for (WatchEvent<?> watchEvent : watchKey.pollEvents()) {
                        WatchEvent.Kind<?> kind = watchEvent.kind();
                        Path path2 = (Path)watchEvent.context();
                        Path path3 = path.resolve(path2);
                        if (!path2.toString().startsWith("img")) continue;
                        System.out.println(String.valueOf(kind) + ": " + String.valueOf(path3));
                    }
                    watchKey.reset();
                }
            }
            catch (Throwable throwable) {
                if (watchService != null) {
                    try {
                        watchService.close();
                    }
                    catch (Throwable throwable2) {
                        throwable.addSuppressed(throwable2);
                    }
                }
                throw throwable;
            }
        }
        catch (IOException | InterruptedException exception) {
            System.err.println(exception.getMessage());
            return;
        }
    }
}
