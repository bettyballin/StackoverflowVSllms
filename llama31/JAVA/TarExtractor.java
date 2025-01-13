import java.io.*;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;

public class TarExtractor {
    public static void extractTar(String tarFile, String destDir) throws IOException {
        try (TarArchiveInputStream tais = new TarArchiveInputStream(new FileInputStream(tarFile))) {
            TarArchiveEntry entry;
            while ((entry = tais.getNextEntry()) != null) {
                if (entry.isDirectory()) {
                    new File(destDir, entry.getName()).mkdirs();
                } else {
                    try (OutputStream os = new FileOutputStream(new File(destDir, entry.getName()))) {
                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = tais.read(buffer)) != -1) {
                            os.write(buffer, 0, bytesRead);
                        }
                    }
                }
            }
        }
    }

    public static void extractTarGz(String tarGzFile, String destDir) throws IOException {
        try (GzipCompressorInputStream gcis = new GzipCompressorInputStream(new FileInputStream(tarGzFile));
             TarArchiveInputStream tais = new TarArchiveInputStream(gcis)) {
            TarArchiveEntry entry;
            while ((entry = tais.getNextEntry()) != null) {
                if (entry.isDirectory()) {
                    new File(destDir, entry.getName()).mkdirs();
                } else {
                    try (OutputStream os = new FileOutputStream(new File(destDir, entry.getName()))) {
                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = tais.read(buffer)) != -1) {
                            os.write(buffer, 0, bytesRead);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String tarFile = "path/to/your/tarfile.tar";
        String destDir = "path/to/your/destination/directory";
        extractTar(tarFile, destDir);

        String tarGzFile = "path/to/your/tarfile.tar.gz";
        extractTarGz(tarGzFile, destDir);
    }
}