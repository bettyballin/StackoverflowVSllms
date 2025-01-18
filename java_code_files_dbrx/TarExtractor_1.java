import java.io.*;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.io.IOUtils;

public class TarExtractor {

    public void extract(String tarFile, String targetDirPath) throws Exception {
        File file = new File(targetDirPath, tarFile);
        try (TarArchiveInputStream is = getTargetOutput(file)) {
            TarArchiveEntry entry;
            while ((entry = is.getNextTarEntry()) != null) {
                System.out.println("Extracting " + file.getName() + "/" + entry.getName());
                File outputFile = new File(targetDirPath, entry.getName());
                if (entry.isDirectory()) {
                    outputFile.mkdirs();
                } else {
                    // Ensures parent directory exists
                    outputFile.getParentFile().mkdirs();
                    writeStream(outputFile, is);
                }
            }
        }
    }

    private TarArchiveInputStream getTargetOutput(File file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        GzipCompressorInputStream gzis = new GzipCompressorInputStream(fis);
        return new TarArchiveInputStream(gzis);
    }

    private void writeStream(final File outputFile, final InputStream is) throws Exception {
        try (OutputStream fos = new BufferedOutputStream(new FileOutputStream(outputFile))) {
            IOUtils.copy(is, fos);
        }
    }
}