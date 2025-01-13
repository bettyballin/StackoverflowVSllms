import java.lang.String;

public class JavaEnvironmentDetector {
    String javaVersion = System.getProperty("java.version");

    public static void main(String[] args) {
        JavaEnvironmentDetector detector = new JavaEnvironmentDetector();
        System.out.println(detector.javaVersion);
    }
}