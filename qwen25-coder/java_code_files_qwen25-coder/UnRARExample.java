import com.github.junrar.Archive;
import com.github.junrar.rarfile.FileHeader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

public class UnRARExample {
    public static void main(String[] args) throws Exception {
        File archiveFile = new File("path/to/your/archive.rar");
        Archive archive = new Archive(archiveFile);

        FileHeader fileHeader = archive.nextFileHeader();
        while (fileHeader != null) {
            if (!fileHeader.isDirectory()) {
                String path = Paths.get("output/directory", fileHeader.getFileNameString()).toString();
                File outputFile = new File(path);
                File directory = outputFile.getParentFile();

                if (directory != null && !directory.exists()) {
                    directory.mkdirs(); // Create the output directory
                }

                try (OutputStream os = new FileOutputStream(outputFile)) {
                    archive.extractFile(fileHeader, os);
                }
            }
            fileHeader = archive.nextFileHeader();
        }
        archive.close();
    }
}