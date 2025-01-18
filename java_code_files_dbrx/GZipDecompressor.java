import java.io.*;
import java.util.concurrent.*;
import java.util.zip.GZIPInputStream;

public class GZipDecompressor {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // List or array of gzipped file paths
        String[] inputFiles = {"file1.gz", "file2.gz"};

        // Create an executor service with a number of threads approximately equal to the number of available processors
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        CompletionService<Void> completionService = new ExecutorCompletionService<>(executor);

        // Submit decompression tasks to the thread pool
        for (String inputFile : inputFiles) {
            Callable<Void> task = () -> {
                try (
                    FileInputStream fis = new FileInputStream(inputFile);
                    GZIPInputStream gzis = new GZIPInputStream(fis);
                    BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("unc_" + inputFile.replace(".gz", "")))
                ) {
                    copyData(gzis, out);
                } catch (IOException ex) {
                    System.err.println("Error decompressing file \"" + inputFile + "\": " + ex);
                }
                return null;
            };

            completionService.submit(task);
        }

        // Process results as tasks complete and shut down the executor service when everything is done
        for (int i = 0; i < inputFiles.length; ++i) {
            completionService.take(); // Waits for a task to complete if none are available
        }

        executor.shutdownNow();
    }

    public static void copyData(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
    }
}