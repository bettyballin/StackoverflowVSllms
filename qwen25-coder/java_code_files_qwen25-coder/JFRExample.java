import java.lang.String;
import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.consumer.RecordingFile;

import java.nio.file.Path;
import java.nio.file.Paths;

public class JFRExample {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("myrecording.jfr");
        try (RecordingFile file = new RecordingFile(path)) {
            while (file.hasMoreEvents()) {
                RecordedEvent event = file.readEvent();
                System.out.println(event);
            }
        }
    }
}