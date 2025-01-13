import java.io.IOException;

public class RunApacheDirectoryStudio {
    public static void main(String[] args) {
        try {
            Runtime.getRuntime().exec("java -jar ApacheDirectoryStudio.jar");
        } catch (IOException e) {
            System.err.println("Error running Apache Directory Studio: " + e.getMessage());
        }
    }
}