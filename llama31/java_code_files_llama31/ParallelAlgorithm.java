/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelAlgorithm {
    public static void main(String[] stringArray) {
        int n = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(n);
        TaskA taskA = new TaskA();
        TaskB taskB = new TaskB();
        TaskC taskC = new TaskC();
        Future<String> future = executorService.submit(taskA);
        Future<String> future2 = executorService.submit(taskB);
        Future<String> future3 = executorService.submit(taskC);
        try {
            String string = future.get();
            String string2 = future2.get();
            String string3 = future3.get();
            String string4 = new TaskD(string, string2, string3).call();
            System.out.println("Final result: " + string4);
        }
        catch (Exception exception) {
            // empty catch block
        }
        executorService.shutdown();
    }
}
