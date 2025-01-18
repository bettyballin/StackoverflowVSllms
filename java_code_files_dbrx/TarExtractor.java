import java.util.Set;
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Files;
import org.apache.commons.compress.archivers.*;
import org.apache.commons.compress.archivers.tar.*;
import org.apache.commons.compress.compressors.gzip.*;
import org.apache.commons.compress.utils.IOUtils;

public class TarExtractor {
    public static void main(String args[]) throws IOException, ArchiveException {
        // Input tar/tar.gz file path and output directory path for extracted files
        String inputFilePath = "<input-path>";
        File outDir = Paths.get("<output-directory>").toFile(); // Add trailing slash if necessary or use Files.createDirectories(Paths.get("")) for automatic creation of missing directories

        ArchiveInputStream decompressedInput = null;

        try (InputStream inputStream = new FileInputStream(inputFilePath)) {
            String lowerCaseFileName = inputFilePath.toLowerCase();
            boolean isGzipFile = lowerCaseFileName.endsWith(".gz") || lowerCaseFileName.endsWith("gzip");

            if (isGzipFile) {
                GzipCompressorInputStream gzDecompressor = new GzipCompressorInputStream(inputStream);
                decompressedInput = new TarArchiveInputStream(gzDecompressor);
            } else {
                decompressedInput = new TarArchiveInputStream(inputStream);
            }

            ArchiveEntry archiveEntry;
            while ((archiveEntry = decompressedInput.getNextEntry()) != null) {
                File outputFile = Paths.get(outDir.toString(), archiveEntry.getName()).toFile(); // Set the path of the extracted file to be a combination of outDir and the name of the current entry
                boolean isDirectory = archiveEntry.isDirectory();
                if (outputFile.exists() && !outputFile.isDirectory()) {
                      throw new ArchiveException("Cannot create a folder where there's already an entry: " + outputFile);
                } else {
                    // Check whether the extracted file needs to be created as a directory or a simple file and handle it appropriately
                    if (isDirectory) {
                        Files.createDirectories(outputFile.toPath());
                    } else {
                        // Ensure parent directories exist
                        Files.createDirectories(outputFile.toPath().getParent());
                        try (OutputStream out = new FileOutputStream(outputFile)) { // Open an outputStream to write the contents of archiveEntry to disk, using a combination of outDir and archiveInput entry name for file pathname
                            IOUtils.copy(decompressedInput, out); // Copy the content of the current entry to 'out'
                        } catch (IOException e) {
                            throw new ArchiveException("Failed writing extracted contents", e);
                        }
                    }
                }
           }
        } catch (FileNotFoundException e) {
             System.err.println("Unable to find input file " + inputFilePath);
        } finally {
          if(decompressedInput != null){
              try{ decompressedInput.close(); }catch (IOException e1) {} // Always ensure decompressedInput is closed to free up system resources appropriately
           }
        }
    }
}