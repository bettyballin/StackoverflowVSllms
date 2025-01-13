import java.lang.String;
import java.io.IOException;
import java.lang.ProcessBuilder;

public class EXECUTE {
    public static void application(String className) throws IOException {
        String[] command = {"java", className};
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.start();
    }

	public static void main(String[] args) {
	}
}