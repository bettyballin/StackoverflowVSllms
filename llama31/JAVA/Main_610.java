import java.io.IOException;

public class Main_610 {
    public static void main(String[] args) throws IOException, InterruptedException {
        String[] cmd = {"ssh", "-t", "user@host", "cd /path/to/somewhere; /bin/bash"};
        Process process = Runtime.getRuntime().exec(cmd);
        process.waitFor();
    }
}