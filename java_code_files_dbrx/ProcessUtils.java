import java.io.IOException;

public class ProcessUtils {
    private void osKillProcessAndChildren(long pid) throws IOException, InterruptedException {
        String[] command = {"/bin/bash", "-c", "kill -9 " + pid + "; killall -9 -s -v -q " + "0"}; // using bash to run a few commands in sequence.
        Runtime.getRuntime().exec(command).waitFor();
    }

    public static void main(String[] args) {
    }
}