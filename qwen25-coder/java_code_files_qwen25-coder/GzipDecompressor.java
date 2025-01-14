import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import java.util.stream.Collectors;

public class GzipDecompressor {

    public static void decompress(String gzipFile, String newFile) throws IOException {
        File file = new File(gzipFile);
        FileInputStream fis = new FileInputStream(file);
        GZIPInputStream gis = new GZIPInputStream(new BufferedInputStream(fis));
        FileOutputStream fos = new FileOutputStream(newFile);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        byte[] buffer = new byte[1024];
        int len;
        while ((len = gis.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }

        // Close resources
        bos.close();
        fos.close();
        gis.close();
        fis.close();
    }

    public static void decompressFilesInDirectory(String directory, String outputDir) throws IOException, InterruptedException {
        Path dirPath = Paths.get(directory);
        List<Path> paths = Files.walk(dirPath)
                .filter(Files::isRegularFile)
                .filter(p -> p.toString().endsWith(".gz"))
                .collect(Collectors.toList());

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (Path path : paths) {
            String outputPath = Paths.get(outputDir, path.getFileName().toString().replace(".gz", "")).toString();
            executorService.execute(() -> {
                try {
                    decompress(path.toString(), outputPath);
                    System.out.println("Decompressed: " + path.toString());
                } catch (IOException e) {
                    System.err.println("Error decompressing file: " + path.toString() + ", exception: " + e.getMessage());
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }

    public static void main(String[] args) {
        try {
            String gzipDirectory = "/path/to/gzip/files";
            String outputDirectory = "/path/to/output/files";
            decompressFilesInDirectory(gzipDirectory, outputDirectory);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}