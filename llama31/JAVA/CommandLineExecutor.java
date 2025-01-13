import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class CommandLineExecutor {
    public static int executeCommandLine(final String commandLine,
                                         final boolean printOutput,
                                         final boolean printError,
                                         final long timeout,
                                         final TimeUnit unit)
            throws IOException, InterruptedException, java.util.concurrent.TimeoutException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(commandLine);

        if (printOutput) {
            BufferedReader outputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            System.out.println("Output:  " + outputReader.readLine());
        }

        if (printError) {
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            System.out.println("Error:  " + errorReader.readLine());
        }

        if (!process.waitFor(timeout, unit)) {
            process.destroyForcibly();
            throw new java.util.concurrent.TimeoutException("Timeout exceeded");
        }

        return process.exitValue();
    }

    public static void main(String[] args) {
    }
}