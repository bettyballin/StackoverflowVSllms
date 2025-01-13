import java.lang.String;

public class ProcessBuilderConfigurator {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder();
        pb.environment().put("CYGWIN", "ntsec");
    }
}