import java.lang.ProcessBuilder;

public class ShellExecutor {
    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("open", "/folder name/toast.sh");
        pb.start();
    }
}