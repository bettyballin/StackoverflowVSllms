import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.exec.PumpStreamHandler;

import java.io.IOException;

public class CommandLineExecutor {
    public static void main(String[] args) {
        String command = "dir"; // Example command on Windows

        CommandLine cmdLine = new CommandLine("cmd");
        cmdLine.addArgument("/c");
        cmdLine.addArgument(command);

        try {
            int exitCode = 0;
            DefaultExecutor executor = new DefaultExecutor();
            ExecuteWatchdog watchdog = new ExecuteWatchdog(60000); // Timeout after 1 minute
            executor.setWatchdog(watchdog);

            PumpStreamHandler streamHandler = new PumpStreamHandler(System.out, System.err);
            executor.setStreamHandler(streamHandler);

            exitCode = executor.execute(cmdLine);

            System.out.println("Exit code: " + exitCode);
        } catch (ExecuteException e) {
            System.err.println("Execution failed.");
        } catch (IOException ioe) {
            System.err.println("Problem occurred while executing command.");
        }
    }
}