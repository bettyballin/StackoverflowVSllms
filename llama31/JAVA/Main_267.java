import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Main_267 {
    public static void main(String[] args) throws IOException {
        CommandLine cmdLine = new CommandLine("cmd.exe");
        cmdLine.addArgument("/c");
        cmdLine.addArgument("x");

        DefaultExecutor executor = new DefaultExecutor();
        PumpStreamHandler streamHandler = new PumpStreamHandler();
        executor.setStreamHandler(streamHandler);

        // Write to the input stream to simulate user input
        streamHandler.setInputStream(new ByteArrayInputStream("y\n".getBytes()));

        executor.execute(cmdLine);
    }
}