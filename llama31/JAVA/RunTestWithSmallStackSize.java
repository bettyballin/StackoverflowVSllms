import java.lang.String;
import java.io.IOException;

public class RunTestWithSmallStackSize {
    public static void main(String[] args) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-Xss1024k", "YourTestClass");
        Process process = processBuilder.start();
    }
}