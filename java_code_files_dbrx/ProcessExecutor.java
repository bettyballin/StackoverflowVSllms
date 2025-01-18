import java.io.File;
import java.io.IOException;

public class ProcessExecutor {
    String[] commands = {"/bin/bash", "-c", "nohup your_script.sh &> /dev/null &"};
    ProcessBuilder pb = new ProcessBuilder(commands);

    {
        pb.directory(new File("/path/to/your_script")); // if required, set the working directory
        try {
            Process p = pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}