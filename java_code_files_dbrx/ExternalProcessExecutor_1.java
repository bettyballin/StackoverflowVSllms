import java.lang.String;
import java.io.IOException;

public class ExternalProcessExecutor_1 {
    Process p;

    {
        try {
            p = Runtime.getRuntime().exec("java -jar MyJar.jar > stdout_file.txt 2> stderr_file.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}