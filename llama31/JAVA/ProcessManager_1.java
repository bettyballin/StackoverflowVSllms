import java.lang.String;

public class ProcessManager_1_1 {
    private Process process;

    public ProcessManager_1(String command) throws Exception {
        process = Runtime.getRuntime().exec(command);

        // Add a shutdown hook to kill the child process when the JVM exits
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                process.destroy();
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new ProcessManager_1("your_command_here"); // replace "your_command_here" with the actual command you want to run
    }
}