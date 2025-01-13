import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public class CommandExecutor_2_2 {
    public void executeCommand(final String command) {
        Job job = new Job("Executing command...") {
            @Override
            protected IStatus run(IProgressMonitor monitor) {
                try {
                    // Create a new console
                    IConsoleManager consoleManager = ConsolePlugin.getDefault().getConsoleManager();
                    IConsole console = consoleManager.newConsole("Command Output", null);
                    consoleManager.addConsole(console);
                    consoleManager.showConsoleView(console);

                    // Create a stream to write to the console
                    MessageConsole messageConsole = (MessageConsole) console;
                    MessageConsoleStream stream = messageConsole.newMessageStream();

                    // Execute the command
                    Process process = Runtime.getRuntime().exec(command);
                    InputStream stdout = process.getInputStream();
                    InputStream stderr = process.getErrorStream();

                    // Pipe stdout and stderr to the console
                    pipeStream(stdout, stream);
                    pipeStream(stderr, stream);

                    // Wait for the process to finish
                    process.waitFor();

                    // Close the stream
                    stream.close();
                } catch (IOException e) {
                    return new Status(IStatus.ERROR, "Error executing command", e);
                } catch (InterruptedException e) {
                    return new Status(IStatus.ERROR, "Error executing command", e);
                }
                return Status.OK_STATUS;
            }
        };
        job.schedule();
    }

    private void pipeStream(InputStream in, MessageConsoleStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
    }

    public static void main(String[] args) {
        // Example usage
        CommandExecutor_2 executor = new CommandExecutor_2();
        executor.executeCommand("echo Hello, World!");
    }
}