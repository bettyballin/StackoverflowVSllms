import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;

public class WatchServiceExample {

    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("/path/to/watch"); // <1>
        try {
            WatchService service = FileSystems.getDefault().newWatchService(); // <2>
            path.register(service, StandardWatchEventKinds.ENTRY_MODIFY); // <3>
            boolean valid = true;
            do {
                WatchKey key; //<4>
                try {
                    key = service.poll(60, TimeUnit.SECONDS); //<5>
                } catch (InterruptedException e) {
                    System.out.println("Someone stopped the Thread!"); // TODO: do something meaningful here instead of printing ...
                    valid = false;
                    continue;
                }
                if (key == null) {
                    System.out.println("Nothing happen in ..."); // TODO: do something meaningful here instead of print out this message
                    continue;
                }
                for (WatchEvent<?> watchEvent : key.pollEvents()) { // <6>
                    WatchEvent<Path> pathEvent = (WatchEvent<Path>) watchEvent; // <7>
                    Path context = pathEvent.context();
                    if (pathEvent.kind() == StandardWatchEventKinds.ENTRY_MODIFY) { // <8>
                        System.out.println("Modified :" + context); // TODO: do something meaningful here instead of print out this message
                    } else {
                        /*do other things based on kind*/
                    }
                }
                valid = key.reset();
            } while (valid && !Thread.currentThread().isInterrupted());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}