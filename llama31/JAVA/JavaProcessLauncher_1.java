import java.lang.String;

public class JavaProcessLauncher_1_1 {
    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), "MyClass");
        pb.inheritIO();
        Process p = pb.start();
    }
}