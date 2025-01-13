import java.lang.String;
import java.lang.Runtime;
import java.lang.Process;

public class DaemonThreadFactory {
    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setDaemon(true); // Make the thread a daemon thread
                return thread;
            }
        };

        String command = "your_command_here"; // replace with your command

        Thread thread = threadFactory.newThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Process process = Runtime.getRuntime().exec(command);
                    // Add a shutdown hook to kill the child process when the JVM exits
                    Runtime.getRuntime().addShutdownHook(new Thread() {
                        @Override
                        public void run() {
                            process.destroy();
                        }
                    });
                } catch (Exception e) {
                    System.err.println("Error executing command: " + e.getMessage());
                }
            }
        });
        thread.start();
    }
}

interface ThreadFactory {
    Thread newThread(Runnable r);
}