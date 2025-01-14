import java.lang.String;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

public class ProcessExample {
    public static void main(String[] args) throws Exception {
        // Create a command line with the executable and arguments
        CommandLine cmdLine = new CommandLine("your/executable");
        cmdLine.addArgument("--option");

        // Prepare an executor
        DefaultExecutor executor = new DefaultExecutor();
        
        // Execute the command
        int exitValue = executor.execute(cmdLine);
        System.out.println("Exit Value: " + exitValue);
    }
}