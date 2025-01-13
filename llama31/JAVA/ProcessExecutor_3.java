import java.lang.String;

public class ProcessExecutor_3_3 {
    final Process process;

    public ProcessExecutor_3(String cmd) throws Exception {
        process = Runtime.getRuntime().exec(cmd);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                process.destroy();
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new ProcessExecutor_3("your_command_here"); // replace "your_command_here" with the actual command you want to execute
    }
}