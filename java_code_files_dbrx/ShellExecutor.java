import java.lang.String;
import java.io.IOException;

public class ShellExecutor {
    static {
        ProcessBuilder pb = new ProcessBuilder("open", "/folder name/toast.sh");
        try {
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}