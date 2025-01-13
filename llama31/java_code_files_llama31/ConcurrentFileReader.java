/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentFileReader {
    public static void main(String[] stringArray) {
        File file = new File("large_file.hex");
        int n = 0xA00000;
        int n2 = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(n2);
        for (long i = 0L; i < file.length(); i += (long)n) {
            long l = Math.min(i + (long)n, file.length());
            executorService.execute(new FileReadingTask(file, i, l));
        }
        executorService.shutdown();
    }
}
