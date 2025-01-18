import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.exec.PumpStreamHandler;

import com.hierynomus.winrm.WinRmClientBuilder;
import com.hierynomus.winrm.ClientConfiguration;
import com.hierynomus.winrm.shell.Shell;
import com.hierynomus.winrm.shell.ShellCommand;
import com.hierynomus.winrm.shell.ShellCommandOutput;
import com.hierynomus.winrm.shell.ShellOptions;

public class RemoteCommandExecutor {
    private static final String WINDOWS_HOST = "example.com";
    private static final int WINDOWS_PORT = 5986; // Default SSL port for WinRM
    private static final String LOGIN = "username";
    private static final String PASSWORD = "password123!";
    private static final String DOMAIN = null; // If you have a domain, use it here, otherwise leave as null.

    public static void main(String[] args) throws Exception {
        CommandLine command = new CommandLine("powershell");
        command.addArgument("-command");
        command.addArgument(".{dir} $args[0]", false);

        Shell shell = createShell();
        int exitValue;
        try {
            ByteArrayOutputStream stdoutStream = new ByteArrayOutputStream();
            ExecuteWatchdog watchdog = new ExecuteWatchdog(TimeUnit.SECONDS.toMillis(5)); // Set the timeout here.

            DefaultExecutor executor = new DefaultExecutor();
            executor.setStreamHandler(new PumpStreamHandler(stdoutStream, System.err));
            executor.setWatchdog(watchdog);

            // Execute the command within the remote shell
            ShellCommand shellCommand = shell.execute(command.toString());
            ShellCommandOutput output = shellCommand.getOutput();

            // Retrieve exit code
            exitValue = output.getExitCode();

            // Read stdout
            String stdout = output.getStdOut();

            // Read stderr
            String stderr = output.getStdErr();

            // Process the outputs as needed
            System.out.println("Exit Value: " + exitValue);
            System.out.println("Output: " + stdout);
            System.err.println("Error: " + stderr);

        } finally {
            shell.close();
        }
    }

    private static Shell createShell() throws IOException {
        WinRmClientBuilder builder = new WinRmClientBuilder()
                .withHost(WINDOWS_HOST)
                .withPort(WINDOWS_PORT)
                .useHttps()
                .disableCertificateChecks(); // Accept self-signed certificates

        if (DOMAIN != null && !DOMAIN.isEmpty()) {
            builder.withDomainAndUsername(DOMAIN, LOGIN)
                   .withPassword(PASSWORD);
        } else {
            builder.withUsername(LOGIN)
                   .withPassword(PASSWORD);
        }

        // Custom WinRM configuration
        ClientConfiguration cfg = new ClientConfiguration()
                .setOperationTimeout((int) TimeUnit.SECONDS.toMillis(90)) // Default operation timeout is 180 seconds
                .setMaxElements(Integer.MAX_VALUE);

        return builder.build().createShell(new ShellOptions(), cfg);
    }
}