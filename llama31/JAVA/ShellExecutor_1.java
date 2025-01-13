import java.lang.ProcessBuilder;

public class ShellExecutor_1_1 {
    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("nohup", "updater_script.sh");
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        pb.redirectError(ProcessBuilder.Redirect.INHERIT);
        Process p = pb.start();
    }
}