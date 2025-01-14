import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.ZoneOffset;

public class FileModificationExample {
    public static void main(String[] args) throws Exception {
        File file = new File("example.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        // Set last modified time to a specific UTC instant
        Instant specificTimeUTC = Instant.parse("2023-10-01T12:00:00Z");
        Files.setLastModifiedTime(file.toPath(), FileTime.from(specificTimeUTC));

        // Get the file attributes and read last modified time in UTC
        BasicFileAttributes attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        Instant fileModInstantUTC = attributes.lastModifiedTime().toInstant();

        System.out.println("Last modified (UTC): " + fileModInstantUTC.atZone(ZoneOffset.UTC));
    }
}