import java.io.IOException;

public class Main_281 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Process p = Runtime.getRuntime().exec("your_command_here"); // replace with your actual command

        // Add a shutdown hook to terminate the process
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                p.destroy();
            }
        });

        p.waitFor();
    }
}