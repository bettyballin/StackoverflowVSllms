import java.lang.String;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.WatchEvent.Kind;
import java.util.concurrent.*;

public class DirectoryCleaner {
    private final Path directory;
    private final long retentionTime; // in milliseconds
    private final ScheduledExecutorService scheduler;
    private final BlockingQueue<Path> deletionQueue;

    public DirectoryCleaner(Path directory, long retentionTime) {
        this.directory = directory;
        this.retentionTime = retentionTime;
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
        this.deletionQueue = new LinkedBlockingQueue<>();

        // Start watching the directory for new files
        startDirectoryWatcher();

        // Start the deletion thread
        scheduler.scheduleAtFixedRate(this::deleteFiles, 0, 1, TimeUnit.MINUTES);
    }

    private void startDirectoryWatcher() {
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            directory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

            while (true) {
                WatchKey key = watchService.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                        Path newFile = directory.resolve((Path) event.context());
                        deletionQueue.add(newFile);
                    }
                }
                key.reset();
            }
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void deleteFiles() {
        long now = System.currentTimeMillis();
        while (!deletionQueue.isEmpty()) {
            Path file = deletionQueue.peek();
            if (now - file.toFile().lastModified() >= retentionTime) {
                deletionQueue.poll();
                try {
                    Files.delete(file);
                } catch (IOException e) {
                    // Handle deletion failure
                }
            } else {
                break; // Files are ordered by creation time, so we can stop here
            }
        }
    }

	public static void main(String[] args) {
	}
}