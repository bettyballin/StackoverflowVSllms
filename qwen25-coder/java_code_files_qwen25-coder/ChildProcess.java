import java.lang.String;
import java.lang.Integer;
public class ChildProcess {
    public static void main(String[] args) throws Exception {
        int parentPid = Integer.parseInt(args[0]);
        
        new Thread(() -> {
            while (isParentAlive(parentPid)) {
                try {
                    Thread.sleep(1000); // Check every second
                } catch (InterruptedException e) {
                    break;
                }
            }
            System.out.println("Parent process is no longer running, shutting down...");
            System.exit(0);
        }).start();

        // Main work of the child process below this point...
    }

    private static boolean isParentAlive(int pid) {
        try {
            Process p = Runtime.getRuntime().exec(new String[]{"ps", "-p", String.valueOf(pid)});
            int exitCode = p.waitFor();
            return exitCode == 0;
        } catch (Exception e) {
            return false;
        }
    }
}