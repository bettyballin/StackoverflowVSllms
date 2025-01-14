import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TarExtractor {

    public static void extractTar(String tarPath, String destFolder) throws IOException {
        try (FileInputStream fis = new FileInputStream(tarPath);
             TarArchiveInputStream tais = new TarArchiveInputStream(fis)) {
            extractContents(tais, destFolder);
        }
    }

    public static void extractTarGz(String tarGzPath, String destFolder) throws IOException {
        try (FileInputStream fis = new FileInputStream(tarGzPath);
             GzipCompressorInputStream gzIn = new GzipCompressorInputStream(fis);
             TarArchiveInputStream tais = new TarArchiveInputStream(gzIn)) {
            extractContents(tais, destFolder);
        }
    }

    public static void extractTarBz2(String tarBz2Path, String destFolder) throws IOException {
        try (FileInputStream fis = new FileInputStream(tarBz2Path);
             BZip2CompressorInputStream bzIn = new BZip2CompressorInputStream(fis);
             TarArchiveInputStream tais = new TarArchiveInputStream(bzIn)) {
            extractContents(tais, destFolder);
        }
    }

    private static void extractContents(TarArchiveInputStream tais, String destPath) throws IOException {
        TarArchiveEntry entry;
        while ((entry = tais.getNextTarEntry()) != null) {
            File destFile = new File(destPath, entry.getName());
            if (entry.isDirectory()) {
                destFile.mkdirs();
            } else {
                destFile.getParentFile().mkdirs();
                try (FileOutputStream fos = new FileOutputStream(destFile)) {
                    byte[] buffer = new byte[4096];
                    int n;
                    while ((n = tais.read(buffer)) != -1) {
                        fos.write(buffer, 0, n);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String destFolder = "/path/to/destination/folder";

        // Uncomment the following line to extract a .tar file
        // extractTar("/path/to/file.tar", destFolder);

        // Uncomment the following line to extract a .tar.gz file
        // extractTarGz("/path/to/file.tar.gz", destFolder);

        // Uncomment the following line to extract a .tar.bz2 file
        // extractTarBz2("/path/to/file.tar.bz2", destFolder);
    }
}