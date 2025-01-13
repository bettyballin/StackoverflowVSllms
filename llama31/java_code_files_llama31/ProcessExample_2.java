/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProcessExample_2 {
    public static void main(String[] stringArray) throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder("my_command");
        Process process = processBuilder.start();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));){
                String string;
                while ((string = bufferedReader.readLine()) != null) {
                    System.out.println(string);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        });
    }
}
