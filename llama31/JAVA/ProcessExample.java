import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.Executor;

public class ProcessExample {
    public static void main(String[] args) throws Exception {
        CommandLine cmd = new CommandLine("my_command");
        Executor executor = new DefaultExecutor();
        executor.execute(cmd);
    }
}