import java.lang.ProcessBuilder;

public class CommandExecutor_6_6 {
    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("your_command");
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        pb.redirectError(ProcessBuilder.Redirect.INHERIT);
        Process p = pb.start();
    }
}