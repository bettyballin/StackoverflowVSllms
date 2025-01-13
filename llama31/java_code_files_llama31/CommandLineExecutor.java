/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CommandLineExecutor {
    public static int executeCommandLine(String string, boolean bl, boolean bl2, long l, TimeUnit timeUnit) throws IOException, InterruptedException, TimeoutException {
        BufferedReader bufferedReader;
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(string);
        if (bl) {
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            System.out.println("Output:  " + bufferedReader.readLine());
        }
        if (bl2) {
            bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            System.out.println("Error:  " + bufferedReader.readLine());
        }
        if (!process.waitFor(l, timeUnit)) {
            process.destroyForcibly();
            throw new TimeoutException("Timeout exceeded");
        }
        return process.exitValue();
    }

    public static void main(String[] stringArray) {
    }
}
