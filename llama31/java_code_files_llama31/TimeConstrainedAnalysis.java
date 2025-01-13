/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TimeConstrainedAnalysis {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> callable = new Callable<String>(){

            @Override
            public String call() throws Exception {
                Thread.sleep(15000L);
                return "Analysis result";
            }
        };
        Future<String> future = executorService.submit(callable);
        try {
            String string = future.get(10L, TimeUnit.SECONDS);
            System.out.println("Result: " + string);
        }
        catch (TimeoutException timeoutException) {
            future.cancel(true);
            System.out.println("Time's up! Returning dummy value");
            System.out.println("Dummy result");
        }
        catch (ExecutionException executionException) {
            System.out.println("Error: " + executionException.getMessage());
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
        finally {
            executorService.shutdown();
        }
    }
}
