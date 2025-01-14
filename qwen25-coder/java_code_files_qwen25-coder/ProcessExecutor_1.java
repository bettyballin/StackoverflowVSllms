import java.io.IOException;

public class ProcessExecutor_1 {
    static {
        try {
            Process process = Runtime.getRuntime().exec("path_to_exe_or_dll");
            // Handle the process output and errors as needed
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}