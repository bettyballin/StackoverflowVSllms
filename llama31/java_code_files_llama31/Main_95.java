/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main_95 {
    public static void main(String[] stringArray) {
        int n = 10;
        int n2 = 5;
        int[] nArray = new int[n * n * n];
        int[] nArray2 = new int[n * n];
        int n3 = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(n3);
        for (int i = 1; i < n2; ++i) {
            for (int j = 0; j < n; ++j) {
                int n4 = 0;
                while (n4 < n) {
                    int n5 = i;
                    int n6 = j;
                    int n7 = n4++;
                    executorService.submit(() -> {
                        int n5 = 0;
                        for (int i = 0; i < n; ++i) {
                            if (nArray[(n7 * n + i) * n + n6] < n5) continue;
                            ++n5;
                        }
                        nArray2[n3 * n + n2] = n5;
                    });
                }
            }
        }
        executorService.shutdown();
    }
}
