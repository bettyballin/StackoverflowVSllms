/*
 * Decompiled with CFR 0.152.
 */
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class Main_63 {
    public static void main(String[] stringArray) throws Exception {
        WatchKey watchKey;
        Path path = Paths.get("path/to/folder", new String[0]);
        WatchService watchService = FileSystems.getDefault().newWatchService();
        path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
        while ((watchKey = watchService.take()) != null) {
            for (WatchEvent<?> watchEvent : watchKey.pollEvents()) {
                if (watchEvent.kind() != StandardWatchEventKinds.ENTRY_MODIFY) continue;
                System.out.println("File has changed: " + String.valueOf(watchEvent.context()));
            }
            watchKey.reset();
        }
    }
}
