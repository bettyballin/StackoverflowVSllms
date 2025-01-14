import java.lang.String;
import java.io.IOException;

public class ProcessLauncher {
    String[] command = {"your_program", "arg1", "arg2"};

    {
        try {
            Process process = Runtime.getRuntime().exec(command);
            // handle the process output and error streams here
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}