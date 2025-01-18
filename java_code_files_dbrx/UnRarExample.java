import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ar.ArArchiveEntry;
import java.io.*;
import org.apache.commons.compress.utils.IOUtils;

public class UnArExample {
    public static void main(String[] args) throws IOException, ArchiveException {
        String inputFile = "input.ar"; // path to your ar file
        InputStream is = new FileInputStream(inputFile);
        try (ArchiveInputStream archiver = new ArchiveStreamFactory().createArchiveInputStream("ar", is)) {
            for (ArArchiveEntry entry = null; (entry = (ArArchiveEntry) archiver.getNextEntry()) != null; ) {
                extractCurrentFile(archiver, entry); // Extract the content to a file which name matches your entry filename
            }
        } finally {
            is.close();
        }
    }

    private static void extractCurrentFile(ArchiveInputStream archiver, ArArchiveEntry currentEntry) throws IOException, ArchiveException {
        String fileName = currentEntry.getName(); // this will be the file name of your input Ar Entry
        try (OutputStream outputStream = new FileOutputStream(fileName)) {
            IOUtils.copy(archiver, outputStream);
        }
    }
}