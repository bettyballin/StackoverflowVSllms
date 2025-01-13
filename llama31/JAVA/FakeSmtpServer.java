import java.io.File;
import java.io.IOException;

public class FakeSmtpServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        String[] command = {"java", "-jar", "fakeSMTP.jar", "-p", "1025", "-o", "outputfolder"};
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
    }
}